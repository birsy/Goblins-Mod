package birsy.goblinsmod.common.item;

import birsy.goblinsmod.common.item.materials.enums.ArmorMaterials;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import javax.annotation.Nullable;
import java.util.List;

public class CrownArmorItem extends ArmorItem {
    public CrownArmorItem() {
        super(ArmorMaterials.CROWN, EquipmentSlotType.HEAD, new Item.Properties().group(GoblinsMod.CASTLE_MOD).rarity(Rarity.EPIC).isImmuneToFire().setNoRepair());
    }

    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.addEnchantment(Enchantments.BINDING_CURSE, 1);
        super.onCreated(stack, worldIn, playerIn);
    }

    public boolean hasEffect(ItemStack stack) {
        return true;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        return new ResourceLocation(GoblinsMod.MOD_ID, "textures/models/armor/crown_texture_placeholder.png").toString();
    }

    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add((new TranslationTextComponent("item.crown.ability").mergeStyle(TextFormatting.GRAY)));
    }
}
