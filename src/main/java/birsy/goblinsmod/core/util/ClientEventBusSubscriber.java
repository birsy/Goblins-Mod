package birsy.goblinsmod.core.util;

import birsy.goblinsmod.common.item.GoblinSpawnEggItem;
import birsy.goblinsmod.core.GoblinsMod;
import birsy.goblinsmod.core.registry.GoblinsEntities;
import net.minecraft.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = GoblinsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber
{
	@SubscribeEvent
	public static void onClientSetup(FMLClientSetupEvent event)
	{
		GoblinsEntities.clientSetup();
	}
	
	@SubscribeEvent
	public static void onRegisterEntities(final RegistryEvent.Register<EntityType<?>> event)
	{
		GoblinSpawnEggItem.initSpawnEggs();
	}
}
