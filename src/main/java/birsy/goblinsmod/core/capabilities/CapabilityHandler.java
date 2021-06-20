package birsy.goblinsmod.core.capabilities;

import birsy.goblinsmod.core.GoblinsMod;
import birsy.goblinsmod.core.capabilities.corruption.CrownCorruptionProvider;
import net.minecraft.entity.CreatureEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = GoblinsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CapabilityHandler
{
    @SubscribeEvent
    public static void onAttachCapabilitiesEvent(AttachCapabilitiesEvent<CreatureEntity> event) {
        CrownCorruptionProvider provider = new CrownCorruptionProvider();
        event.addCapability(new ResourceLocation(GoblinsMod.MOD_ID, "corruption"), provider);
        event.addListener(provider::invalidate);
    }
}
