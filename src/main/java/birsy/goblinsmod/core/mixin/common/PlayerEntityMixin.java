package birsy.goblinsmod.core.mixin.common;

import birsy.goblinsmod.common.item.EelsteelArmorItem;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

//@Mixin(PlayerEntity.class)
public abstract class PlayerEntityMixin extends LivingEntity {

    protected PlayerEntityMixin(EntityType<? extends LivingEntity> type, World worldIn) {
        super(type, worldIn);
    }

    //@Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/entity/player/PlayerEntity;onGround:Z", shift = At.Shift.AFTER), method = "addMovementStat")
    private void addMovementStat(double xDis, double yDis, double zDis, CallbackInfo info) {
        float l = Math.round(MathHelper.sqrt(xDis * xDis + zDis * zDis) * 100.0F) / 100.0F;
        if (l > 0 && this.isOnGround()) {
            for (EquipmentSlotType slot : EquipmentSlotType.values()) {
                ItemStack stack = this.getItemStackFromSlot(slot);
                if (stack.getItem() instanceof EelsteelArmorItem) {
                    ((EelsteelArmorItem) stack.getItem()).charge(stack, this);
                }
            }
        }
    }
}
