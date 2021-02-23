package birsy.goblinsmod.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.EnumSet;
import java.util.List;

public class SanctumiteEntity extends MonsterEntity {
    public List<Entity> possessedEntities;
    public List<BlockPos> possessedBlocks;

    public double prevChasingPosX;
    public double prevChasingPosY;
    public double prevChasingPosZ;
    public double chasingPosX;
    public double chasingPosY;
    public double chasingPosZ;

    private float rollAmount;
    private float rollAmount1;
    private float pitchAmount;
    private float pitchAmount1;

    public static final DataParameter<Boolean> INCORPOREAL = EntityDataManager.createKey(SanctumiteEntity.class, DataSerializers.BOOLEAN);
    private int incorporealTicks;
    public int incorporealTransitionTicks;

    public SanctumiteEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.moveController = new SanctumiteEntity.MoveHelperController(this);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(8, new SanctumiteEntity.MoveRandomGoal());
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookAtGoal(this, IllusionerEntity.class, 6.0F));
        this.goalSelector.addGoal(8, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30.0)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(INCORPOREAL, false);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("incorporeal", this.isIncorporeal());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.dataManager.set(INCORPOREAL, compound.getBoolean("incorporeal"));
    }

    public boolean isIncorporeal() {
        return this.dataManager.get(INCORPOREAL);
    }

    public void setIncorporeal(boolean incorporeal) {
        this.dataManager.set(INCORPOREAL, incorporeal);
        this.incorporealTransitionTicks = 40;
        if (incorporeal) {
            this.playSound(SoundEvents.ENTITY_ILLUSIONER_CAST_SPELL, 1.0F, 1.0F);
        } else {
            this.playSound(SoundEvents.ENTITY_EVOKER_CAST_SPELL, 1.0F, 1.0F);
        }
    }

    public void tick() {
        if (this.isIncorporeal()) {
            this.noClip = true;
            this.incorporealTicks++;
        }

        super.tick();
        this.updateCape();

        this.noClip = false;
        this.setNoGravity(true);
    }

    @Override
    public void livingTick() {
        super.livingTick();
    }

    class MoveRandomGoal extends Goal {
        public MoveRandomGoal() {
            this.setMutexFlags(EnumSet.of(Goal.Flag.MOVE));
        }

        public boolean shouldExecute() {
            return !SanctumiteEntity.this.getMoveHelper().isUpdating() && SanctumiteEntity.this.rand.nextInt(7) == 0;
        }

        public boolean shouldContinueExecuting() {
            return false;
        }

        public void tick() {
            BlockPos blockpos = SanctumiteEntity.this.getPosition();

            for(int i = 0; i < 3; ++i) {
                BlockPos blockpos1 = blockpos.add(SanctumiteEntity.this.rand.nextInt(15) - 7, SanctumiteEntity.this.rand.nextInt(11) - 5, SanctumiteEntity.this.rand.nextInt(15) - 7);
                if (SanctumiteEntity.this.world.isAirBlock(blockpos1)) {
                    SanctumiteEntity.this.moveController.setMoveTo((double)blockpos1.getX() + 0.5D, (double)blockpos1.getY() + 0.5D, (double)blockpos1.getZ() + 0.5D, 0.25D);
                    break;
                }
            }
        }
    }

    class MoveHelperController extends MovementController {
        public MoveHelperController(SanctumiteEntity sanctumite) {
            super(sanctumite);
        }

        public void tick() {
            if (this.action == MovementController.Action.MOVE_TO) {
                Vector3d vector3d = new Vector3d(this.posX - SanctumiteEntity.this.getPosX(), this.posY - SanctumiteEntity.this.getPosY(), this.posZ - SanctumiteEntity.this.getPosZ());
                double d0 = vector3d.length();
                if (d0 < SanctumiteEntity.this.getBoundingBox().getAverageEdgeLength()) {
                    this.action = MovementController.Action.WAIT;
                    SanctumiteEntity.this.setMotion(SanctumiteEntity.this.getMotion().scale(0.5D));
                } else {
                    SanctumiteEntity.this.setMotion(SanctumiteEntity.this.getMotion().add(vector3d.scale(this.speed * 0.05D / d0)));
                    if (SanctumiteEntity.this.getAttackTarget() == null) {
                        Vector3d vector3d1 = SanctumiteEntity.this.getMotion();
                        SanctumiteEntity.this.rotationYaw = -((float) MathHelper.atan2(vector3d1.x, vector3d1.z)) * (180F / (float)Math.PI);
                        SanctumiteEntity.this.renderYawOffset = SanctumiteEntity.this.rotationYaw;
                    } else {
                        double d2 = SanctumiteEntity.this.getAttackTarget().getPosX() - SanctumiteEntity.this.getPosX();
                        double d1 = SanctumiteEntity.this.getAttackTarget().getPosZ() - SanctumiteEntity.this.getPosZ();
                        SanctumiteEntity.this.rotationYaw = -((float)MathHelper.atan2(d2, d1)) * (180F / (float)Math.PI);
                        SanctumiteEntity.this.renderYawOffset = SanctumiteEntity.this.rotationYaw;
                    }
                }

            }
        }
    }

    /**
     * Client Stuff!
     */

    private void updateCape() {
        this.prevChasingPosX = this.chasingPosX;
        this.prevChasingPosY = this.chasingPosY;
        this.prevChasingPosZ = this.chasingPosZ;
        double d0 = this.getPosX() - this.chasingPosX;
        double d1 = this.getPosY() - this.chasingPosY;
        double d2 = this.getPosZ() - this.chasingPosZ;
        double d3 = 10.0D;
        if (d0 > 10.0D) {
            this.chasingPosX = this.getPosX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 > 10.0D) {
            this.chasingPosZ = this.getPosZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 > 10.0D) {
            this.chasingPosY = this.getPosY();
            this.prevChasingPosY = this.chasingPosY;
        }

        if (d0 < -10.0D) {
            this.chasingPosX = this.getPosX();
            this.prevChasingPosX = this.chasingPosX;
        }

        if (d2 < -10.0D) {
            this.chasingPosZ = this.getPosZ();
            this.prevChasingPosZ = this.chasingPosZ;
        }

        if (d1 < -10.0D) {
            this.chasingPosY = this.getPosY();
            this.prevChasingPosY = this.chasingPosY;
        }

        this.chasingPosX += d0 * 0.25D;
        this.chasingPosZ += d2 * 0.25D;
        this.chasingPosY += d1 * 0.25D;
    }

    private void updateBodyPitch() {
        this.rollAmount1 = this.rollAmount;
        this.rollAmount = Math.max(0.0F, this.rollAmount - 0.24F);
    }

    @OnlyIn(Dist.CLIENT)
    public float getBodyPitch(float p_226455_1_) {
        return MathHelper.lerp(p_226455_1_, this.rollAmount1, this.rollAmount);
    }
}
