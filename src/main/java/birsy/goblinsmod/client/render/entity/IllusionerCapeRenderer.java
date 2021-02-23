package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoblinsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class IllusionerCapeRenderer {
    private static CapedIllusionerRenderer capedIllusionerRenderer;

    @SubscribeEvent
    public static void renderIllusioner(final RenderLivingEvent.Pre event) {
        if(event.getEntity() instanceof IllusionerEntity) {
            event.setCanceled(true);

            if (null == capedIllusionerRenderer) {
                Minecraft mc = Minecraft.getInstance();
                capedIllusionerRenderer = new CapedIllusionerRenderer(mc.getRenderManager());
            }

            capedIllusionerRenderer.renderWithoutRecursion((IllusionerEntity) event.getEntity(), event.getEntity().rotationYaw, event.getPartialRenderTick(), event.getMatrixStack(), event.getBuffers(), capedIllusionerRenderer.getPackedLight((IllusionerEntity) event.getEntity(), event.getPartialRenderTick()));
        }
    }
}
