package birsy.goblinsmod.core.registry;

import birsy.goblinsmod.common.item.CrownArmorItem;
import birsy.goblinsmod.common.item.GoblinSpawnEggItem;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class GoblinsItems
{
	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, GoblinsMod.MOD_ID);

	public static final RegistryObject<Item> EELSKIN_PLATE = createItem("eelskin_plate", () -> new Item(new Item.Properties().group(GoblinsMod.CASTLE_MOD)));
	public static final RegistryObject<Item> CORRUPTED_CROWN = createItem("corrupted_crown", CrownArmorItem::new);

	public static final RegistryObject<GoblinSpawnEggItem> GHOUL_SPAWN_EGG = createItem("ghoul_spawn_egg",
			() -> new GoblinSpawnEggItem(GoblinsEntities.GHOUL, 0x85494C, 0x6E7058, new Item.Properties().group(GoblinsMod.CASTLE_MOD)));

	public static <I extends Item> RegistryObject<I> createItem(String name, Supplier<? extends I> item) {
		return ITEMS.register(name, item);
	}
}
