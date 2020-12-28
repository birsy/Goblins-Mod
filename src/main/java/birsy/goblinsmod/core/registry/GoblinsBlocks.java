package birsy.goblinsmod.core.registry;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.block.Block;
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
	
	//Material Blocks
	//public static final RegistryObject<Block> LEAD_BLOCK = createBlock("lead_block", () -> new MetalMaterialBlock(), Clinker.CLINKER_BLOCKS);
	
	public static <B extends Block> RegistryObject<B> createBlock(String name, final Supplier<? extends B> supplier, @Nullable ItemGroup group) {
		RegistryObject<B> block = BLOCKS.register(name, supplier);
		if (group != null) {
			ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(group)));
		}
		return block;
	}
}
