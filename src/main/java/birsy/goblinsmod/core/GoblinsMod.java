package birsy.goblinsmod.core;

import birsy.goblinsmod.core.registry.GoblinsBlocks;
import birsy.goblinsmod.core.registry.GoblinsEntities;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
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

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        GoblinsEntities.setup();
        LOGGER.info("A goblin army is approaching from the west!");
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        //LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().gameSettings);
    }
}
