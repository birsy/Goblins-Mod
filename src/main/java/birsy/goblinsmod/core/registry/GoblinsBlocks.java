package birsy.goblinsmod.core.registry;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import birsy.goblinsmod.common.block.RottenOozeBlock;
import birsy.goblinsmod.common.block.RottenSludgeBlock;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class GoblinsBlocks
{
	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, GoblinsMod.MOD_ID);
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoblinsMod.MOD_ID);
	
	// Blocks

	/**
	 * GRIMSTONE
	 * Like nether bricks, but less terrible.
	 * Works quite well with nether bricks though.
	 */
	private static final AbstractBlock.Properties grimstoneProperties = AbstractBlock.Properties
			.create(Material.ROCK, MaterialColor.BLACK_TERRACOTTA)
			.setRequiresTool()
			.hardnessAndResistance(5.0F, 6.0F)
			.sound(SoundType.GILDED_BLACKSTONE);

	public static final RegistryObject<Block> GRIMSTONE = createBlock("grimstone", () -> new Block(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_SLAB = createBlock("grimstone_slab", () -> new SlabBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_STAIRS = createBlock("grimstone_stairs", () -> new StairsBlock(() -> GRIMSTONE.get().getDefaultState(), grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_WALL = createBlock("grimstone_wall", () -> new WallBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);

	public static final RegistryObject<Block> POLISHED_GRIMSTONE = createBlock("polished_grimstone", () -> new Block(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> POLISHED_GRIMSTONE_SLAB = createBlock("polished_grimstone_slab", () -> new SlabBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> POLISHED_GRIMSTONE_STAIRS = createBlock("polished_grimstone_stairs", () -> new StairsBlock(() -> POLISHED_GRIMSTONE.get().getDefaultState(), grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> POLISHED_GRIMSTONE_WALL = createBlock("polished_grimstone_wall", () -> new WallBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);

	public static final RegistryObject<Block> GRIMSTONE_BRICKS = createBlock("grimstone_bricks", () -> new Block(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> CRACKED_GRIMSTONE_BRICKS = createBlock("cracked_grimstone_bricks", () -> new Block(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_BRICK_SLAB = createBlock("grimstone_brick_slab", () -> new SlabBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_BRICK_STAIRS = createBlock("grimstone_brick_stairs", () -> new StairsBlock(() -> GRIMSTONE_BRICKS.get().getDefaultState(), grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_BRICK_WALL = createBlock("grimstone_brick_wall", () -> new WallBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);

	public static final RegistryObject<Block> GRIMSTONE_TILES = createBlock("grimstone_tiles", () -> new Block(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> CRACKED_GRIMSTONE_TILES = createBlock("cracked_grimstone_tiles", () -> new Block(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_TILE_SLAB = createBlock("grimstone_tile_slab", () -> new SlabBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_TILE_STAIRS = createBlock("grimstone_tile_stairs", () -> new StairsBlock(() -> GRIMSTONE_TILES.get().getDefaultState(), grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_TILE_WALL = createBlock("grimstone_tile_wall", () -> new WallBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);

	public static final RegistryObject<Block> CHISELED_GRIMSTONE = createBlock("chiseled_grimstone", () -> new Block(grimstoneProperties), GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> GRIMSTONE_PILLAR = createBlock("grimstone_pillar", () -> new RotatedPillarBlock(grimstoneProperties), GoblinsMod.CASTLE_MOD);

	/**
	 * NETHER BRICK TILES
	 * Some additional nether brick items to make building with them easier.
	 * Will work as the flooring for the imp jails.
	 */
	private static final AbstractBlock.Properties netherBrickProperties = AbstractBlock.Properties
			.create(Material.ROCK, MaterialColor.NETHERRACK)
			.setRequiresTool()
			.hardnessAndResistance(2.0F, 6.0F)
			.sound(SoundType.NETHER_BRICK);

	public static final RegistryObject<Block> NETHER_BRICK_TILES = createBlock("nether_brick_tiles", () -> new Block(netherBrickProperties), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> CRACKED_NETHER_BRICK_TILES = createBlock("cracked_nether_brick_tiles", () -> new Block(netherBrickProperties), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> NETHER_BRICK_TILE_SLAB = createBlock("nether_brick_tile_slab", () -> new SlabBlock(netherBrickProperties), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> NETHER_BRICK_TILE_STAIRS = createBlock("nether_brick_tile_stairs", () -> new StairsBlock(() -> NETHER_BRICK_TILES.get().getDefaultState(), netherBrickProperties), ItemGroup.BUILDING_BLOCKS);
	public static final RegistryObject<Block> NETHER_BRICK_TILE_WALL = createBlock("nether_brick_tile_wall", () -> new WallBlock(netherBrickProperties), ItemGroup.BUILDING_BLOCKS);

	/**
	 * ROTTEN SLUDGE
	 * Occurs within the Rotten Heart fight - slows down the player.
	 */
	public static final RegistryObject<Block> ROTTEN_SLUDGE = createBlock("rotten_sludge", RottenSludgeBlock::new, GoblinsMod.CASTLE_MOD);
	public static final RegistryObject<Block> ROTTEN_OOZE = createBlock("rotten_ooze", RottenOozeBlock::new, GoblinsMod.CASTLE_MOD);

	public static <B extends Block> RegistryObject<B> createBlock(String name, final Supplier<? extends B> supplier, @Nullable ItemGroup group) {
		RegistryObject<B> block = BLOCKS.register(name, supplier);
		if (group != null) {
			ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group)));
		}
		return block;
	}
}
