package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeMaker;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class GoblinsBiomes {
    public static final DeferredRegister<Biome> BIOMES = DeferredRegister.create(ForgeRegistries.BIOMES, GoblinsMod.MOD_ID);

    public static final RegistryObject<Biome> SCARRED_CLIFFS = BIOMES.register("scarred_cliffs", () -> BiomeMaker.makeVoidBiome());
    public static final RegistryObject<Biome> SCARRED_CLIFFS_SHORE = BIOMES.register("scarred_cliffs_shore", () -> BiomeMaker.makeVoidBiome());
    public static final RegistryObject<Biome> GOBLIN_BASIN = BIOMES.register("goblin_basin", () -> BiomeMaker.makeVoidBiome());

    public static void registerBiomes() {
        registerBiome("scarred_cliffs", SCARRED_CLIFFS.get(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome("scarred_cliffs_shore", SCARRED_CLIFFS_SHORE.get(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
        registerBiome("goblin_basin", GOBLIN_BASIN.get(), BiomeManager.BiomeType.WARM, BiomeDictionary.Type.MOUNTAIN, BiomeDictionary.Type.OVERWORLD);
    }

    public static void registerBiome(String name, Biome biome, BiomeManager.BiomeType type, BiomeDictionary.Type... types) {
        BiomeManager.addBiome(type, new BiomeManager.BiomeEntry(RegistryKey.getOrCreateKey(Registry.BIOME_KEY, new ResourceLocation(GoblinsMod.MOD_ID, name)), 5));
    }
}
