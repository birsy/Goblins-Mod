package birsy.goblinsmod.common.event;

import birsy.goblinsmod.core.GoblinsMod;
import birsy.goblinsmod.core.capabilities.corruption.CorruptionCapability;
import birsy.goblinsmod.core.registry.GoblinsItems;
import birsy.goblinsmod.core.util.MathUtils;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoblinsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TickEventHandler {
    @SubscribeEvent
    public static void tickPlayer(final TickEvent.PlayerTickEvent event) {
        ItemStack itemstack = event.player.getItemStackFromSlot(EquipmentSlotType.HEAD);

        if (itemstack.getItem() == GoblinsItems.CORRUPTED_CROWN.get()) {
            event.player.getCapability(CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY).ifPresent(crownCorruption -> {
                crownCorruption.corrupt(10.0d);
                GoblinsMod.LOGGER.info("Corruption for " + event.player.getDisplayName().getString() + "is at " + crownCorruption.getCorruption() + "!");
            });
        } else {
            event.player.getCapability(CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY).ifPresent(crownCorruption -> {
                crownCorruption.purify(2.0d);
                GoblinsMod.LOGGER.info("Corruption for " + event.player.getDisplayName().getString() + "is at " + crownCorruption.getCorruption() + "!");
            });
        }
    }

    @SubscribeEvent
    public static void setSize(final EntityEvent.Size event) {
        if (event.getEntity().isAddedToWorld() && event.getEntity() instanceof CreatureEntity) {
            ItemStack itemstack = ((CreatureEntity) event.getEntity()).getItemStackFromSlot(EquipmentSlotType.HEAD);
            if (itemstack.getItem() == GoblinsItems.CORRUPTED_CROWN.get()) {
                event.getEntity().getCapability(CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY).ifPresent(crownCorruption -> {
                    float size = MathUtils.mapRange(0, 256, 0, 1.5f, (float) crownCorruption.getCorruption());

                    event.setNewSize(EntitySize.flexible(event.getOldSize().width, event.getOldSize().height * size));
                    event.setNewEyeHeight(event.getOldEyeHeight() * size);

                    GoblinsMod.LOGGER.info("Corruption for " + event.getEntity().getDisplayName().getString() + "is at " + crownCorruption.getCorruption() + "!");
                });

                event.setNewSize(EntitySize.flexible(event.getOldSize().width, event.getOldSize().height * 1.5f));
                event.setNewEyeHeight(event.getOldEyeHeight() * 1.5f);
            }
        }
    }
}
