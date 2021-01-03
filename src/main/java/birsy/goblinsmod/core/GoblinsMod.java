package birsy.goblinsmod.core;

import birsy.goblinsmod.core.registry.*;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(GoblinsMod.MOD_ID)
public class GoblinsMod
{
    public static final String MOD_ID = "goblins_mod";

    private static final Logger LOGGER = LogManager.getLogger();

    public GoblinsMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

        GoblinsBlocks.BLOCKS.register(eventBus);
        GoblinsBlocks.ITEMS.register(eventBus);
        GoblinsEntities.ENTITY_TYPES.register(eventBus);
        GoblinsFeatures.FEATURES.register(eventBus);
        GoblinsBiomes.BIOMES.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        event.enqueueWork(() -> {
            GoblinsEntities.setup();
            GoblinsConfiguredFeatures.registerConfiguredFeatures();
            }
        );
        LOGGER.info("A goblin army is approaching from the west!");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD, modid = GoblinsMod.MOD_ID)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onRegisterBiomes(final RegistryEvent.Register<Biome> event) {
            GoblinsBiomes.registerBiomes();
        }
    }
}
