package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.block.Blocks;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GoblinsConfiguredFeatures {
    public static final ConfiguredFeature<?, ?> COBBLESTONE_VEIN = Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, Blocks.COBBLESTONE.getDefaultState(), 40)).range(256).square().func_242731_b(10);
    public static final ConfiguredFeature<?, ?> GRASS_FLOOR = Feature.DELTA_FEATURE.withConfiguration(new BasaltDeltasFeature(Blocks.GRASS_BLOCK.getDefaultState(), Blocks.COARSE_DIRT.getDefaultState(), FeatureSpread.func_242253_a(3, 4), FeatureSpread.func_242253_a(1, 2))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(40)));
    public static final ConfiguredFeature<?, ?> SMALL_CRAGROCK = GoblinsFeatures.CRAGROCK.get().withConfiguration(new ColumnConfig(FeatureSpread.func_242252_a(1), FeatureSpread.func_242253_a(1, 3))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1)));
    public static final ConfiguredFeature<?, ?> LARGE_CRAGROCK = GoblinsFeatures.CRAGROCK.get().withConfiguration(new ColumnConfig(FeatureSpread.func_242253_a(2, 1), FeatureSpread.func_242253_a(5, 5))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(1)));
    public static final ConfiguredFeature<?, ?> BEACH_DELTA = Feature.DELTA_FEATURE.withConfiguration(new BasaltDeltasFeature(Blocks.WATER.getDefaultState(), Blocks.GRAVEL.getDefaultState(), FeatureSpread.func_242253_a(3, 4), FeatureSpread.func_242253_a(1, 2))).withPlacement(Placement.COUNT_MULTILAYER.configure(new FeatureSpreadConfig(40)));
    public static final ConfiguredFeature<?, ?> BOULDER = Feature.FOREST_ROCK.withConfiguration(new BlockStateFeatureConfig(Blocks.COBBLESTONE.getDefaultState())).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242732_c(5);

    public static void registerConfiguredFeatures() {
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;

        Registry.register(registry, new ResourceLocation(GoblinsMod.MOD_ID, "cobblestone_vein"), COBBLESTONE_VEIN);
        Registry.register(registry, new ResourceLocation(GoblinsMod.MOD_ID, "grass_floor"), GRASS_FLOOR);
        Registry.register(registry, new ResourceLocation(GoblinsMod.MOD_ID, "small_cragrock"), SMALL_CRAGROCK);
        Registry.register(registry, new ResourceLocation(GoblinsMod.MOD_ID, "large_cragrock"), LARGE_CRAGROCK);
        Registry.register(registry, new ResourceLocation(GoblinsMod.MOD_ID, "beach_delta"), BEACH_DELTA);
        Registry.register(registry, new ResourceLocation(GoblinsMod.MOD_ID, "boulder"), BOULDER);
    }
}
