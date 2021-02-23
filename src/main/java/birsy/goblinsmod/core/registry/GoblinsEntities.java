package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.client.render.entity.CobuntoRenderer;
import birsy.goblinsmod.client.render.entity.GoblinRenderer;
import birsy.goblinsmod.client.render.entity.HobgoblinRenderer;
import birsy.goblinsmod.client.render.entity.SanctumiteRenderer;
import birsy.goblinsmod.common.entity.CobuntoEntity;
import birsy.goblinsmod.common.entity.GoblinEntity;
import birsy.goblinsmod.common.entity.HobgoblinEntity;
import birsy.goblinsmod.common.entity.SanctumiteEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GoblinsEntities
{
	public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, GoblinsMod.MOD_ID);

	//Entity Types
	public static final RegistryObject<EntityType<CobuntoEntity>> COBUNTO = ENTITY_TYPES.register("cobunto",
			() -> EntityType.Builder.create(CobuntoEntity::new, EntityClassification.MONSTER)
					.size(2.5f, 3.75f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "cobunto").toString()));


	public static final RegistryObject<EntityType<SanctumiteEntity>> SANCTUMITE = ENTITY_TYPES.register("sanctumite",
			() -> EntityType.Builder.create(SanctumiteEntity::new, EntityClassification.MONSTER)
					.size(1.0f, 1.25f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "sanctumite").toString()));


	public static final RegistryObject<EntityType<GoblinEntity>> GOBLIN = ENTITY_TYPES.register("goblin",
			() -> EntityType.Builder.create(GoblinEntity::new, EntityClassification.MONSTER)
					.size(1.0625f, 2.125f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "goblin").toString()));

	public static final RegistryObject<EntityType<HobgoblinEntity>> HOBGOBLIN = ENTITY_TYPES.register("hobgoblin",
			() -> EntityType.Builder.create(HobgoblinEntity::new, EntityClassification.MONSTER)
			.size(1.5f, 3.75f)
			.build(new ResourceLocation(GoblinsMod.MOD_ID, "hobgoblin").toString()));


	public static void setup()
	{
		GlobalEntityTypeAttributes.put(GoblinsEntities.COBUNTO.get(), HobgoblinEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(GoblinsEntities.SANCTUMITE.get(), HobgoblinEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(GoblinsEntities.GOBLIN.get(), GoblinEntity.setCustomAttributes().create());
		GlobalEntityTypeAttributes.put(GoblinsEntities.HOBGOBLIN.get(), HobgoblinEntity.setCustomAttributes().create());
	}

	public static void clientSetup() {
		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.COBUNTO.get(), CobuntoRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.SANCTUMITE.get(), SanctumiteRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.GOBLIN.get(), GoblinRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.HOBGOBLIN.get(), HobgoblinRenderer::new);
	}
}
