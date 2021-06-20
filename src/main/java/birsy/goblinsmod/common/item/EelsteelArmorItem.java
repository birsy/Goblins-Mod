package birsy.goblinsmod.common.item;

import birsy.goblinsmod.common.item.materials.enums.ArmorMaterials;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class EelsteelArmorItem extends ArmorItem {
    public static final String NBT_TAG = "Charge";

    public EelsteelArmorItem(EquipmentSlotType slot) {
        super(ArmorMaterials.EELSTEEL, slot, new Item.Properties().group(ItemGroup.COMBAT));
    }

    public void charge(ItemStack stack, LivingEntity entity) {

    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("item.eelsteel_armor.ability")).mergeStyle(TextFormatting.GREEN).mergeStyle(TextFormatting.BOLD));
    }
}
