package birsy.goblinsmod.client.render;

import birsy.goblinsmod.client.render.entity.CapedIllusionerRenderer;
import birsy.goblinsmod.client.render.entity.layers.IllusionerCapeLayer;
import birsy.goblinsmod.client.render.entity.layers.KingCrownLayer;
import birsy.goblinsmod.core.GoblinsMod;
import birsy.goblinsmod.core.capabilities.corruption.CorruptionCapability;
import birsy.goblinsmod.core.registry.GoblinsItems;
import birsy.goblinsmod.core.util.MathUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.entity.BipedRenderer;
import net.minecraft.client.renderer.entity.IllagerRenderer;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoblinsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ClientRenderEvents {

    @SubscribeEvent
    public static void renderLiving(final RenderLivingEvent.Pre<CreatureEntity, ?> event) {
        ItemStack itemstack = event.getEntity().getItemStackFromSlot(EquipmentSlotType.HEAD);
        KingCrownLayer crownLayer = new KingCrownLayer(event.getRenderer(), 0.75f, 0.75f, 0.75f);

        if (itemstack.getItem() == GoblinsItems.CORRUPTED_CROWN.get()) {
            event.getMatrixStack().push();
            event.getMatrixStack().scale(1.5f, 1.5f, 1.5f);

            event.getRenderer().layerRenderers.removeIf(layerRenderer -> layerRenderer instanceof KingCrownLayer);
            event.getRenderer().layerRenderers.add(crownLayer);
        } else {
            event.getRenderer().layerRenderers.removeIf(layerRenderer -> layerRenderer instanceof KingCrownLayer);
        }

        event.getEntity().getCapability(CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY).ifPresent(crownCorruption -> {
            float size = MathUtils.mapRange(0, 256, 0, 1.5f, (float) crownCorruption.getCorruption());
            event.getMatrixStack().push();
            event.getMatrixStack().scale(size, size, size);});

        if (event.getEntity() instanceof IllusionerEntity) {
            IllusionerCapeLayer capeLayer = new IllusionerCapeLayer(event.getRenderer());
            event.getRenderer().layerRenderers.removeIf(layerRenderer -> layerRenderer instanceof IllusionerCapeLayer);
            event.getRenderer().layerRenderers.add(capeLayer);
        }
    }

    @SubscribeEvent
    public static void renderLivingPost(final RenderLivingEvent.Post<CreatureEntity, ?> event) {
        event.getEntity().getCapability(CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY).ifPresent(crownCorruption -> {
            event.getMatrixStack().pop();
        });

        ItemStack itemstack = event.getEntity().getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (itemstack.getItem() == GoblinsItems.CORRUPTED_CROWN.get()) {
            event.getMatrixStack().pop();
        }
    }
    /**
    //@SubscribeEvent
    public static void renderPlayer(final RenderPlayerEvent.Pre event) {
        ItemStack itemstack = event.getPlayer().getItemStackFromSlot(EquipmentSlotType.HEAD);
        KingCrownLayer crownLayer = new KingCrownLayer<>(event.getRenderer(), 0.75f, 0.75f, 0.75f);

        if(itemstack.getItem() == GoblinsItems.CORRUPTED_CROWN.get()) {
            event.getMatrixStack().push();
            event.getMatrixStack().scale(1.5f, 1.5f, 1.5f);
            event.getMatrixStack().pop();

            event.getRenderer().layerRenderers.removeIf(layerRenderer -> layerRenderer instanceof KingCrownLayer);
            event.getRenderer().layerRenderers.add(crownLayer);
        } else {
            event.getRenderer().layerRenderers.removeIf(layerRenderer -> layerRenderer instanceof KingCrownLayer);
        }
    }
    */
}
