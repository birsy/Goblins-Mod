package birsy.goblinsmod.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
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
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class HobgoblinEntity extends AbstractGoblinEntity {
    protected static final DataParameter<Boolean> HOLDING_CLUB = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<Integer> GOBLIN_RANK = EntityDataManager.createKey(HobgoblinEntity.class, DataSerializers.VARINT);

    public int attackTick;

    public HobgoblinEntity(EntityType<? extends AbstractGoblinEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0D, true));
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
                .createMutableAttribute(Attributes.MAX_HEALTH, 12.0)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D)
                .createMutableAttribute(Attributes.KNOCKBACK_RESISTANCE, 0.75D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 3.0D)
                .createMutableAttribute(Attributes.ATTACK_KNOCKBACK, 1.2D);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(GOBLIN_RANK, 12);
        this.dataManager.register(HOLDING_CLUB, false);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("GoblinRank", 12);
        compound.putBoolean("HoldingClub", this.isHoldingClub());
    }
    
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setGoblinRank(compound.getInt("GoblinRank"));
        this.setHoldingClub(compound.getBoolean("HoldingClub"));
    }

    public boolean isHoldingClub() {
        return this.dataManager.get(HOLDING_CLUB);
    }

    public void setHoldingClub(boolean HoldingClub) {
        this.dataManager.set(HOLDING_CLUB, HoldingClub);
    }

    public boolean getGoblinRank() {
        return (this.dataManager.get(GOBLIN_RANK) & 1) != 0;
    }

    public void setGoblinRank(int rank) {
        this.dataManager.set(GOBLIN_RANK, rank);
    }

    public void livingTick() {
        if (this.isAlive()) {
            if (this.isMovementBlocked()) {
                this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.0D);
            }

            if (this.attackTick > 0) {
                --this.attackTick;
            }

            LOGGER.info("Attack tick for Hobgoblin " + this.getEntityId() + " is at " + this.getAttackTick() + "!");
        }
        super.livingTick();
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        this.attackTick = 15;
        this.world.setEntityState(this, (byte)4);
        this.playSound(SoundEvents.ENTITY_HOGLIN_ATTACK, 1.0F, 1.0F);
        return super.attackEntityAsMob(entityIn);
    }

    private float getAttackDamage() {
        return (float)this.getAttributeValue(Attributes.ATTACK_DAMAGE);
    }

    @OnlyIn(Dist.CLIENT)
    public int getAttackTick() {
        return this.attackTick;
    }
}
