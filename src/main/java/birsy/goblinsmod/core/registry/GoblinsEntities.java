package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.client.render.entity.HobgoblinRenderer;
import birsy.goblinsmod.common.entity.HobgoblinEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@SuppressWarnings("deprecation")
public class GoblinsEntities
{
	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, GoblinsMod.MOD_ID);

	//Entity Types
	public static final RegistryObject<EntityType<HobgoblinEntity>> HOBGOBLIN = ENTITY_TYPES.register("hobgoblin",
			() -> EntityType.Builder.create(HobgoblinEntity::new, EntityClassification.MONSTER)
			.size(1.5f, 3.75f)
			.build(new ResourceLocation(GoblinsMod.MOD_ID, "hobgoblin").toString()));


	public static void setup()
	{
		DeferredWorkQueue.runLater(() -> {
			GlobalEntityTypeAttributes.put(GoblinsEntities.HOBGOBLIN.get(), HobgoblinEntity.setCustomAttributes().create());
		});
	}

	public static void clientSetup() {
		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.HOBGOBLIN.get(), HobgoblinRenderer::new);
	}
}
