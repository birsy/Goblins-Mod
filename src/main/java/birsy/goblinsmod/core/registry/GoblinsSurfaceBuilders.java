package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.common.level.gen.surfacebuilder.RockyForestSurfaceBuilder;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GoblinsSurfaceBuilders {
    public static final DeferredRegister<SurfaceBuilder<?>> SURFACE_BUILDERS = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, GoblinsMod.MOD_ID);

    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> SCARRED_CLIFFS_BUILDER = SURFACE_BUILDERS.register("scarred_cliffs_builder", () -> new RockyForestSurfaceBuilder(SurfaceBuilderConfig.CODEC));
}
