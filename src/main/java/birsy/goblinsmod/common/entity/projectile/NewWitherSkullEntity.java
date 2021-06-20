package birsy.goblinsmod.common.entity.projectile;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class NewWitherSkullEntity extends MobEntity {
    protected static final DataParameter<Boolean> CHARGED = EntityDataManager.createKey(NewWitherSkullEntity.class, DataSerializers.BOOLEAN);

    public NewWitherSkullEntity(EntityType<? extends MobEntity> type, World worldIn) {
        super(type, worldIn);
    }

    public void registerData() {
        super.registerData();
        this.dataManager.register(CHARGED, false);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("Charged", this.isCharged());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setCharged(compound.getBoolean("Charged"));
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes()
    {
        return MobEntity.func_233666_p_()
                .createMutableAttribute(Attributes.MAX_HEALTH, 1.0)
                .createMutableAttribute(Attributes.MOVEMENT_SPEED, 0.25D);
    }

    public boolean isCharged() {
        return this.dataManager.get(CHARGED);
    }

    public void setCharged(boolean charged) {
        this.dataManager.set(CHARGED, charged);
    }
}
