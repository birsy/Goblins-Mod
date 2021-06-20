package birsy.goblinsmod.common.entity;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.controller.BodyController;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Optional;

public class BarnacleEntity extends CreatureEntity {
    public static final DataParameter<Direction> ATTACHED_FACE = EntityDataManager.createKey(BarnacleEntity.class, DataSerializers.DIRECTION);
    public static final DataParameter<Optional<BlockPos>> ATTACHED_BLOCK_POS = EntityDataManager.createKey(BarnacleEntity.class, DataSerializers.OPTIONAL_BLOCK_POS);

    public BarnacleEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public void registerGoals() {
        this.goalSelector.addGoal(1, new BarnacleLookGoal(this, PlayerEntity.class));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(ATTACHED_FACE, Direction.DOWN);
        this.dataManager.register(ATTACHED_BLOCK_POS, Optional.empty());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.dataManager.set(ATTACHED_FACE, Direction.byIndex(compound.getByte("AttachFace")));
        if (compound.contains("APX")) {
            int i = compound.getInt("APX");
            int j = compound.getInt("APY");
            int k = compound.getInt("APZ");
            this.dataManager.set(ATTACHED_BLOCK_POS, Optional.of(new BlockPos(i, j, k)));
        } else {
            this.dataManager.set(ATTACHED_BLOCK_POS, Optional.empty());
        }
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putByte("AttachFace", (byte)this.dataManager.get(ATTACHED_FACE).getIndex());
        BlockPos blockpos = this.getAttachmentPos();
        if (blockpos != null) {
            compound.putInt("APX", blockpos.getX());
            compound.putInt("APY", blockpos.getY());
            compound.putInt("APZ", blockpos.getZ());
        }
    }

    public Direction getAttachmentFacing() {
        return this.dataManager.get(ATTACHED_FACE);
    }

    @Nullable
    public BlockPos getAttachmentPos() {
        return this.dataManager.get(ATTACHED_BLOCK_POS).orElse((BlockPos)null);
    }

    public void setAttachmentPos(@Nullable BlockPos pos) {
        this.dataManager.set(ATTACHED_BLOCK_POS, Optional.ofNullable(pos));
    }

    public void setPosition(double x, double y, double z) {
        super.setPosition(x, y, z);
        if (this.dataManager != null && this.ticksExisted != 0) {
            Optional<BlockPos> optional = this.dataManager.get(ATTACHED_BLOCK_POS);
            if (this.isAddedToWorld() && this.world instanceof net.minecraft.world.server.ServerWorld) ((net.minecraft.world.server.ServerWorld)this.world).chunkCheck(this); // Forge - Process chunk registration after moving.
            Optional<BlockPos> optional1 = Optional.of(new BlockPos(x, y, z));
            if (!optional1.equals(optional)) {
                this.dataManager.set(ATTACHED_BLOCK_POS, optional1);
                this.isAirBorne = true;
            }

        }
    }

    public void livingTick() {
        super.livingTick();
        this.setMotion(Vector3d.ZERO);
        if (!this.isAIDisabled()) {
            this.prevRenderYawOffset = 0.0F;
            this.renderYawOffset = 0.0F;
        }
    }

    private static class BarnacleLookGoal extends LookAtGoal {
        public BarnacleLookGoal(BarnacleEntity entityIn, Class<? extends LivingEntity> watchTargetClass) {
            super(entityIn, watchTargetClass, 8.0F);
        }

        @Override
        public boolean shouldExecute() {
            if (entity instanceof BarnacleEntity) {
                if (((BarnacleEntity) entity).getAttachmentFacing() != Direction.UP) {
                    return super.shouldExecute();
                }
            }

            return false;
        }
    }

    protected boolean canTriggerWalking() {
        return false;
    }

    public boolean canDespawn(double distanceToClosestPlayer) {
        return false;
    }

    protected BodyController createBodyController() {
        return new BarnacleEntity.BodyHelperController(this);
    }

    class BodyHelperController extends BodyController {
        public BodyHelperController(MobEntity entity) {
            super(entity);
        }

        public void updateRenderAngles() {
        }
    }
}
