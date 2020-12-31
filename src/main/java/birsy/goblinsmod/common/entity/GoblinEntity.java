package birsy.goblinsmod.common.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.World;

public class GoblinEntity extends AbstractGoblinEntity {
    protected static final DataParameter<Integer> GOBLIN_RANK = EntityDataManager.createKey(GoblinEntity.class, DataSerializers.VARINT);
    private int chargeCooldown;

    public GoblinEntity(EntityType<? extends AbstractGoblinEntity> type, World worldIn) {
        super(type, worldIn);
        this.setCanPickUpLoot(true);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        //this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
       // this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(3, new LeapAtTargetGoal(this, 0.5F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    protected void updateMovementGoalFlags() {
        boolean flag = !(this.getControllingPassenger() instanceof MobEntity) || this.getControllingPassenger().getType().isContained(EntityTypeTags.RAIDERS);
        boolean flag1 = !(this.getRidingEntity() instanceof BoatEntity);
        this.goalSelector.setFlag(Goal.Flag.MOVE, flag);
        this.goalSelector.setFlag(Goal.Flag.JUMP, flag && flag1);
        this.goalSelector.setFlag(Goal.Flag.LOOK, flag);
        this.goalSelector.setFlag(Goal.Flag.TARGET, flag);
    }

    //func_233666_p_ --> registerAttributes
    public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 30.0)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(GOBLIN_RANK, 3);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("GoblinRank", 3);
    }
    
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setGoblinRank(compound.getInt("GoblinRank"));
    }

    public boolean getGoblinRank() {
        return (this.dataManager.get(GOBLIN_RANK) & 1) != 0;
    }

    public void setGoblinRank(int rank) {
        this.dataManager.set(GOBLIN_RANK, rank);
    }

    @Override
    public void tick() {
        if (chargeCooldown > 0) {
            chargeCooldown--;
        }

        super.tick();
    }

    public class GoblinChargeGoal extends Goal {
        GoblinEntity goblin;

        @Override
        public boolean shouldExecute() {
            if (goblin.rand.nextInt(10) == 0 && goblin.chargeCooldown == 0) {
                return goblin.getAttackTarget() != null;
            } else {
                return false;
            }
        }
    }
}
