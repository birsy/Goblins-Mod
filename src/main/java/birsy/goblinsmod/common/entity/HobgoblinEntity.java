package birsy.goblinsmod.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;

public class HobgoblinEntity extends AbstractGoblinEntity {
    private static final DataParameter<Boolean> HOLDING_CLUB = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> GOBLIN_RANK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.VARINT);

    public int slamWindupTime = 90;
    private static final DataParameter<Boolean> CHARGING_SLAM_ATTACK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.BOOLEAN);

    public int leftArmWindupTime = 60;
    private static final DataParameter<Boolean> CHARGING_LEFT_ARM_ATTACK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> PREV_LEFT_ARM_ATTACK_TICK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> LEFT_ARM_ATTACK_TICK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.VARINT);

    public int rightArmWindupTime = 60;
    private static final DataParameter<Boolean> CHARGING_RIGHT_ARM_ATTACK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Integer> PREV_RIGHT_ARM_ATTACK_TICK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> RIGHT_ARM_ATTACK_TICK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.VARINT);

    public HobgoblinEntity(EntityType<? extends AbstractGoblinEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(2, new MoveTowardsTargetGoal(this, 0.9D, 32.0F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, BatEntity.class, true));
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
                .createMutableAttribute(Attributes.MAX_HEALTH, 40.0)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 6.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.2D);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(GOBLIN_RANK, 12);
        this.dataManager.register(HOLDING_CLUB, false);

        this.dataManager.register(CHARGING_SLAM_ATTACK, false);

        this.dataManager.register(CHARGING_LEFT_ARM_ATTACK, false);
        this.dataManager.register(PREV_LEFT_ARM_ATTACK_TICK, 0);
        this.dataManager.register(LEFT_ARM_ATTACK_TICK, 0);

        this.dataManager.register(CHARGING_RIGHT_ARM_ATTACK, false);
        this.dataManager.register(PREV_RIGHT_ARM_ATTACK_TICK, 0);
        this.dataManager.register(RIGHT_ARM_ATTACK_TICK, 0);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("GoblinRank", this.getGoblinRank());
        compound.putBoolean("HoldingClub", this.isHoldingClub());

        compound.putBoolean("ChargingSlamAttack", this.isChargingSlamAttack());

        compound.putBoolean("ChargingLeftArmAttack", this.isChargingLeftArmAttack());
        compound.putInt("PrevLeftArmAttackTicks", this.dataManager.get(PREV_LEFT_ARM_ATTACK_TICK));
        compound.putInt("LeftArmAttackTicks", this.dataManager.get(LEFT_ARM_ATTACK_TICK));

        compound.putBoolean("ChargingRightArmAttack", this.isChargingRightArmAttack());
        compound.putInt("PrevRightArmAttackTicks", this.dataManager.get(PREV_RIGHT_ARM_ATTACK_TICK));
        compound.putInt("RightArmAttackTicks", this.dataManager.get(RIGHT_ARM_ATTACK_TICK));
    }
    
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setGoblinRank(compound.getInt("GoblinRank"));
        this.setHoldingClub(compound.getBoolean("HoldingClub"));

        this.setChargingSlamAttack(compound.getBoolean("ChargingSlamAttack"));

        this.setChargingLeftArmAttack(compound.getBoolean("ChargingLeftArmAttack"));
        this.dataManager.set(PREV_LEFT_ARM_ATTACK_TICK, compound.getInt("PrevLeftArmAttackTicks"));
        this.setLeftAttackTicks(compound.getInt("LeftArmAttackTicks"));

        this.setChargingRightArmAttack(compound.getBoolean("ChargingRightArmAttack"));
        this.dataManager.set(PREV_RIGHT_ARM_ATTACK_TICK, (compound.getInt("PrevRightArmAttackTicks")));
        this.setRightAttackTicks(compound.getInt("RightArmAttackTicks"));
    }

    public boolean isHoldingClub() {
        return this.dataManager.get(HOLDING_CLUB);
    }
    public void setHoldingClub(boolean HoldingClub) {
        this.dataManager.set(HOLDING_CLUB, HoldingClub);
    }

    public int getGoblinRank() {
        return (this.dataManager.get(GOBLIN_RANK));
    }
    public void setGoblinRank(int rank) {
        this.dataManager.set(GOBLIN_RANK, rank);
    }


    public boolean isChargingSlamAttack() {
        return this.dataManager.get(CHARGING_SLAM_ATTACK);
    }
    public void setChargingSlamAttack(boolean charging) {
        this.dataManager.set(CHARGING_SLAM_ATTACK, charging);
    }

    public boolean isChargingLeftArmAttack() {
        return this.dataManager.get(CHARGING_LEFT_ARM_ATTACK);
    }
    public void setChargingLeftArmAttack(boolean charging) {
        this.dataManager.set(CHARGING_LEFT_ARM_ATTACK, charging);
    }
    public void setLeftAttackTicks(int ticks) {
        this.dataManager.set(LEFT_ARM_ATTACK_TICK, ticks);
    }
    public float getLeftAttackTicks(float partialTicks) {
        return MathHelper.lerp(partialTicks, this.dataManager.get(PREV_LEFT_ARM_ATTACK_TICK), this.dataManager.get(LEFT_ARM_ATTACK_TICK));
    }

    public boolean isChargingRightArmAttack() {
        return this.dataManager.get(CHARGING_RIGHT_ARM_ATTACK);
    }
    public void setChargingRightArmAttack(boolean charging) {
        this.dataManager.set(CHARGING_RIGHT_ARM_ATTACK, charging);
    }
    public void setRightAttackTicks(int ticks) {
        this.dataManager.set(RIGHT_ARM_ATTACK_TICK, ticks);
    }
    public float getRightAttackTicks(float partialTicks) {
        return MathHelper.lerp(partialTicks, this.dataManager.get(PREV_RIGHT_ARM_ATTACK_TICK), this.dataManager.get(RIGHT_ARM_ATTACK_TICK));
    }


    public void livingTick() {
        if (this.isAlive()) {
            if (this.isMovementBlocked()) {
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
            }
        }
        super.livingTick();
    }

    @Override
    public void tick() {
        super.tick();
        this.dataManager.set(PREV_RIGHT_ARM_ATTACK_TICK, this.dataManager.get(RIGHT_ARM_ATTACK_TICK));
        this.dataManager.set(PREV_LEFT_ARM_ATTACK_TICK, this.dataManager.get(LEFT_ARM_ATTACK_TICK));

        if (this.isChargingLeftArmAttack()) {
            if (this.dataManager.get(LEFT_ARM_ATTACK_TICK) < leftArmWindupTime) {
                this.setLeftAttackTicks((int) (this.dataManager.get(LEFT_ARM_ATTACK_TICK) + 1));
            } else {
                this.leftPunch();
            }
        } else if (rand.nextInt(40) == 0) {
            chargeLeftPunch();
        }

        if (this.isChargingRightArmAttack()) {
            if (this.dataManager.get(RIGHT_ARM_ATTACK_TICK) < rightArmWindupTime) {
                this.setRightAttackTicks((int) (this.dataManager.get(RIGHT_ARM_ATTACK_TICK) + 1));
            } else {
                this.rightPunch();
            }
        } else if (rand.nextInt(40) == 0) {
            chargeRightPunch();
        }
    }

    /**
     * Begins to charge a left hook.
     * @return Returns false if there's already a punch in progress.
     */
    public boolean chargeLeftPunch() {
        if (!this.isChargingSlamAttack() && !this.isChargingLeftArmAttack()) {
            this.setChargingLeftArmAttack(true);
            return true;
        } else {
            return false;
        }
    }

    public void leftPunch() {
        if (this.isChargingLeftArmAttack()) {
            this.setChargingLeftArmAttack(false);
            this.setLeftAttackTicks(0);

            Vector3d offsetVector = new Vector3d(this.rotationYaw, 0, rotationPitch).normalize().mul(1.5f, 1.5f, 1.5f);
            offsetVector.add(new Vector3d(this.rotationYaw, 0, rotationPitch).rotateYaw(90).normalize());

            List<Entity> attackedEntities = this.world.getEntitiesWithinAABB(LivingEntity.class, this.getBoundingBox().offset(offsetVector));
            for (Entity entity : attackedEntities) {
                if (entity != this) {
                    this.attackEntityAsMob(entity);
                }
            }

            this.playSound(SoundEvents.ENTITY_HOGLIN_ATTACK, 1.0f, 0.85f);
        }
    }

    /**
     * Begins to charge a right hook.
     * @return Returns false if there's already a punch in progress.
     */
    public boolean chargeRightPunch() {
        if (!this.isChargingSlamAttack() && !this.isChargingRightArmAttack()) {
            this.setChargingRightArmAttack(true);
            return true;
        } else {
            return false;
        }
    }

    public void rightPunch() {
        if (this.isChargingRightArmAttack()) {
            this.setChargingRightArmAttack(false);
            this.setRightAttackTicks(0);

            Vector3d offsetVector = new Vector3d(this.rotationYaw, 0, rotationPitch).normalize().mul(1.5f, 1.5f, 1.5f);
            offsetVector.add(new Vector3d(this.rotationYaw, 0, rotationPitch).rotateYaw(-90).normalize());

            List<Entity> attackedEntities = this.world.getEntitiesWithinAABB(LivingEntity.class, this.getBoundingBox().offset(offsetVector));
            for (Entity entity : attackedEntities) {
                if (entity != this) {
                    this.attackEntityAsMob(entity);
                }
            }

            this.playSound(SoundEvents.ENTITY_HOGLIN_ATTACK, 1.0f, 0.85f);
        }
    }

    /**
     * Begins to charge a two-fist slam.
     * @return Returns false if there's already a punch in progress.
     */
    public boolean chargeSlam() {
        if (!this.isChargingSlamAttack() && !this.isChargingRightArmAttack() && !this.isChargingLeftArmAttack()) {
            this.setChargingSlamAttack(true);
            return true;
        } else {
            return false;
        }
    }

    public void slam() {
        if (this.isChargingSlamAttack()) {
            this.setChargingSlamAttack(false);
            this.setRightAttackTicks(0);
            this.setLeftAttackTicks(0);

            List<Entity> attackedEntities = this.world.getEntitiesWithinAABB(LivingEntity.class, this.getBoundingBox().grow(1.5, -3, 1.5));
            for (Entity entity : attackedEntities) {
                if (entity != this) {
                    this.attackEntityAsMob(entity);
                    entity.addVelocity(0, 0.6, 0);
                }
            }

            for (int particleNum = 0; particleNum < 30; particleNum++) {
                int x = MathHelper.floor(this.getPosX());
                int y = MathHelper.floor(this.getPosY() - (double)0.2F);
                int z = MathHelper.floor(this.getPosZ());
                BlockPos pos = new BlockPos(x, y, z);
                BlockState blockstate = this.world.getBlockState(pos);
                if (blockstate.isSolid()) {
                    this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getPosX() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), this.getPosY() + 0.1D, this.getPosZ() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
                }
            }

            this.playSound(SoundEvents.ENTITY_HOGLIN_ATTACK, 1.0f, 0.85f);
        }
    }
}
