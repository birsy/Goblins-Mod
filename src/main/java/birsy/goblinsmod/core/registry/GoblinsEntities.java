package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.client.render.entity.*;
import birsy.goblinsmod.common.entity.*;
import birsy.goblinsmod.common.entity.boss.king_boss.CorruptedKingEntity;
import birsy.goblinsmod.common.entity.projectile.NewWitherSkullEntity;
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

	public static final RegistryObject<EntityType<SchnozEntity>> SCHNOZ = ENTITY_TYPES.register("schnoz",
			() -> EntityType.Builder.create(SchnozEntity::new, EntityClassification.CREATURE)
					.size(1.25f, 1.625f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "schnoz").toString()));



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

	public static final RegistryObject<EntityType<GhoulEntity>> GHOUL = ENTITY_TYPES.register("ghoul",
			() -> EntityType.Builder.create(GhoulEntity::new, EntityClassification.MONSTER)
					.size(0.8f, 2.4f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "ghoul").toString()));

	/**
	 * BOSSES
	 */
	public static final RegistryObject<EntityType<CorruptedKingEntity>> CORRUPTED_KING = ENTITY_TYPES.register("corrupted_king",
			() -> EntityType.Builder.create(CorruptedKingEntity::new, EntityClassification.MONSTER)
					.size(2.0f, 5.5f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "corrupted_king").toString()));


	/**
	 * PROJECTILES
	 */
	public static final RegistryObject<EntityType<NewWitherSkullEntity>> NEW_WITHER_SKULL = ENTITY_TYPES.register("new_wither_skull",
			() -> EntityType.Builder.create(NewWitherSkullEntity::new, EntityClassification.MISC)
					.size(0.5f, 0.5f)
					.build(new ResourceLocation(GoblinsMod.MOD_ID, "new_wither_skull").toString()));


	public static void setup()
	{
		GlobalEntityTypeAttributes.put(GoblinsEntities.SCHNOZ.get(), SchnozEntity.setCustomAttributes().create());


		GlobalEntityTypeAttributes.put(GoblinsEntities.COBUNTO.get(), HobgoblinEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(GoblinsEntities.SANCTUMITE.get(), SanctumiteEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(GoblinsEntities.GOBLIN.get(), GoblinEntity.setCustomAttributes().create());
		GlobalEntityTypeAttributes.put(GoblinsEntities.HOBGOBLIN.get(), HobgoblinEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(GoblinsEntities.GHOUL.get(), GhoulEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(GoblinsEntities.CORRUPTED_KING.get(), CorruptedKingEntity.setCustomAttributes().create());

		GlobalEntityTypeAttributes.put(GoblinsEntities.NEW_WITHER_SKULL.get(), NewWitherSkullEntity.setCustomAttributes().create());
	}

	public static void clientSetup() {
		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.SCHNOZ.get(), SchnozRenderer::new);


		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.COBUNTO.get(), CobuntoRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.SANCTUMITE.get(), SanctumiteRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.GOBLIN.get(), GoblinRenderer::new);
		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.HOBGOBLIN.get(), HobgoblinRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.GHOUL.get(), GhoulRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.CORRUPTED_KING.get(), CorruptedKingRenderer::new);

		RenderingRegistry.registerEntityRenderingHandler(GoblinsEntities.NEW_WITHER_SKULL.get(), WitherSkullRenderer::new);
	}
}
