package birsy.goblinsmod.common.entity;

import birsy.goblinsmod.core.util.MathUtils;
import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;

public class GhoulEntity extends MonsterEntity {
    private static final DataParameter<Float> SIZE = EntityDataManager.createKey(GhoulEntity.class, DataSerializers.FLOAT);

    private static final DataParameter<Float> HEAD_ROTATION = EntityDataManager.createKey(GhoulEntity.class, DataSerializers.FLOAT);
    private static final DataParameter<Float> ARM_HEIGHT = EntityDataManager.createKey(GhoulEntity.class, DataSerializers.FLOAT);

    private static final DataParameter<Integer> RED = EntityDataManager.createKey(GhoulEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> GREEN = EntityDataManager.createKey(GhoulEntity.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> BLUE = EntityDataManager.createKey(GhoulEntity.class, DataSerializers.VARINT);

    private int baseEmergingTicks = 45;
    private int emergingTickLength;
    private int emergingTicks = emergingTickLength;
    private int prevEmergingTicks = emergingTickLength;

    public GhoulEntity (EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
        this.emergingTickLength = (int) (this.baseEmergingTicks * this.getSize());

        this.emergingTicks = emergingTickLength;
        this.prevEmergingTicks = emergingTickLength;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes () {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 15.0)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.3D)
                .createMutableAttribute(Attributes.ATTACK_DAMAGE, 4.0D);
    }

    @Override
    protected void registerGoals()
    {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        //this.goalSelector.addGoal(5, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(0, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
        //this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setCallsForHelp());
        //this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, PlayerEntity.class, true));
    }

    public void registerData() {
        super.registerData();
        this.dataManager.register(SIZE, 1.0f);
        this.dataManager.register(HEAD_ROTATION, 0.0f);
        this.dataManager.register(ARM_HEIGHT, 0.0f);

        this.dataManager.register(RED, 255);
        this.dataManager.register(GREEN, 255);
        this.dataManager.register(BLUE, 255);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putFloat("Size", getSize());
        compound.putFloat("Head_Rotation", getHeadRotation());
        compound.putFloat("Arm_Height", getArmHeight());

        compound.putFloat("Red", MathHelper.clamp(getRed(), 0, 255));
        compound.putFloat("Green", MathHelper.clamp(getGreen(), 0, 255));
        compound.putFloat("Blue", MathHelper.clamp(getBlue(), 0, 255));
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setSize(compound.getFloat("Size"));
        this.setHeadRotation(compound.getFloat("Head_Rotation"));
        this.setArmHeight(compound.getFloat("Arm_Height"));

        this.setRed(compound.getInt("Red"));
        this.setGreen(compound.getInt("Green"));
        this.setBlue(compound.getInt("Blue"));
    }

    public float getSize() {
        return this.dataManager.get(SIZE);
    }
    public void setSize(float size) {
        this.dataManager.set(SIZE, size);
    }

    public float getHeadRotation() {
        return this.dataManager.get(HEAD_ROTATION);
    }
    public void setHeadRotation(float rotation) {
        this.dataManager.set(HEAD_ROTATION, rotation);
    }

    public float getArmHeight() {
        return this.dataManager.get(ARM_HEIGHT);
    }
    public void setArmHeight(float height) {
        this.dataManager.set(ARM_HEIGHT, height);
    }

    public int getRed() {
        return this.dataManager.get(RED);
    }
    public void setRed(int value) {
        this.dataManager.set(RED, MathHelper.clamp(value, 0, 255));
    }
    public int getGreen() {
        return this.dataManager.get(GREEN);
    }
    public void setGreen(int value) {
        this.dataManager.set(GREEN, MathHelper.clamp(value, 0, 255));
    }
    public int getBlue() {
        return this.dataManager.get(BLUE);
    }
    public void setBlue(int value) {
        this.dataManager.set(BLUE, MathHelper.clamp(value, 0, 255));
    }


    protected void setSize(float size, boolean resetHealth) {
        this.dataManager.set(SIZE, size);

        this.emergingTickLength = (int) (this.baseEmergingTicks * this.getSize());
        this.setBoundingBox(new AxisAlignedBB(this.getPosition().add(-this.getBoundingBox().getXSize() / 2, 0, -this.getBoundingBox().getZSize() / 2),
                this.getPosition().add(this.getBoundingBox().getXSize() / 2, this.getBoundingBox().getYSize(), this.getBoundingBox().getZSize() / 2)));
        this.recenterBoundingBox();
        this.recalculateSize();

        this.getAttribute(Attributes.MAX_HEALTH)    .setBaseValue(this.getAttribute(Attributes.MAX_HEALTH).getBaseValue() * size);
        this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(this.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() - (size - 1));
        this.getAttribute(Attributes.ATTACK_DAMAGE) .setBaseValue(this.getAttribute(Attributes.MAX_HEALTH).getBaseValue() * size);
        if (resetHealth) {
            this.setHealth(this.getMaxHealth());
        }
    }

    @Override
    public void tick () {
        this.prevEmergingTicks = this.emergingTicks;
        this.emergingTickLength = (int) (this.baseEmergingTicks * this.getSize());

        if (this.emergingTicks > 0) {
            int x = MathHelper.floor(this.getPosX());
            int y = MathHelper.floor(this.getPosY() - (double)0.2F);
            int z = MathHelper.floor(this.getPosZ());
            BlockPos pos = new BlockPos(x, y, z);
            BlockState blockstate = this.world.getBlockState(pos);
            if (blockstate.isSolid()) {
                this.world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, blockstate).setPos(pos), this.getPosX() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), this.getPosY() + 0.1D, this.getPosZ() + ((double)this.rand.nextFloat() - 0.5D) * (double)this.getWidth(), 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
            }

            this.emergingTicks--;
        }

        super.tick();
    }

    @Nullable
    @Override
    public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
        this.setHeadRotation((float) Math.toRadians(MathUtils.getRandomFloatBetween(rand, -25.0f, 25.0f)));
        this.setArmHeight(MathUtils.getRandomFloatBetween(rand, -13.0f, 0.2f));
        this.setSize(MathUtils.getRandomFloatBetween(rand, 0.8f, 1.2f), true);

        float value = MathUtils.getRandomFloatBetween(rand, 0.6f, 1.0f);
        this.setRed   ((int) (MathUtils.getRandomIntegerBetween(rand, 192, 255) * value));
        this.setGreen ((int) (MathUtils.getRandomIntegerBetween(rand, 192, 255) * value));
        this.setBlue  ((int) (MathUtils.getRandomIntegerBetween(rand, 128, 255) * value));

        return super.onInitialSpawn(worldIn, difficultyIn, reason, spawnDataIn, dataTag);
    }

    @OnlyIn(Dist.CLIENT)
    public float getEmergingTicks (float partialTicks) {
        return MathHelper.lerp(partialTicks, prevEmergingTicks, emergingTicks);
    }

    @OnlyIn(Dist.CLIENT)
    public float getEmergingTicksNormalized (float partialTicks) {
        return MathUtils.mapRange(0, emergingTickLength, 0, 1, getEmergingTicks(partialTicks));
    }

    public void summonReinforcements () {

    }
}
