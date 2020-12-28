package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("deprecation")
public class GoblinsEntities
{
	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, GoblinsMod.MOD_ID);
	
	public static void init()
	{
		ENTITY_TYPES.register(FMLJavaModLoadingContext.get().getModEventBus());
	}
	
	public static void setup()
	{
    	DeferredWorkQueue.runLater(() -> {
    		//GlobalEntityTypeAttributes.put(GoblinsEntities.WITCH_BRICK.get(), WitchBrickEntity.setCustomAttributes().create());
    	});
	}
	
	//Entity Types
	/**
	public static final RegistryObject<EntityType<SnailEntity>> SNAIL = ENTITY_TYPES.register("snail",
			() -> EntityType.Builder.create(SnailEntity::new, EntityClassification.CREATURE)
			.size(1.0f, 1.0f)
			.build(new ResourceLocation(Clinker.MOD_ID, "snail").toString()));
	 */
}
