package birsy.goblinsmod.client.render.entity.layers;

import birsy.goblinsmod.client.render.entity.model.CrownModel;
import birsy.goblinsmod.core.GoblinsMod;
import birsy.goblinsmod.core.registry.GoblinsItems;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class KingCrownLayer<T extends LivingEntity, M extends EntityModel<T> & IHasHead> extends LayerRenderer<T, M> {
   private static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/models/armor/corrupted_crown.png");
   private static final CrownModel crown = new CrownModel();

   private final float xScale;
   private final float yScale;
   private final float zScale;

   public KingCrownLayer(IEntityRenderer<T, M> renderer, float xScale, float yScale, float zScale) {
      super(renderer);
      this.xScale = xScale;
      this.yScale = yScale;
      this.zScale = zScale;
   }

   public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      ItemStack itemstack = entitylivingbaseIn.getItemStackFromSlot(EquipmentSlotType.HEAD);
      //Returns true if it contains anything except the curse of binding.
      boolean enchanted = EnchantmentHelper.getEnchantments(itemstack).containsKey(Enchantments.BINDING_CURSE) ? EnchantmentHelper.getEnchantments(itemstack).size()-1 > 0 : EnchantmentHelper.getEnchantments(itemstack).size() > 0;

      if (itemstack.getItem() == GoblinsItems.CORRUPTED_CROWN.get()) {
         matrixStackIn.push();

         matrixStackIn.scale(this.xScale, this.yScale, this.zScale);
         this.getEntityModel().getModelHead().translateRotate(matrixStackIn);

         if (entitylivingbaseIn.isChild()) {
            matrixStackIn.translate(0.0D, 0.03125D, 0.0D);
            matrixStackIn.scale(0.7F, 0.7F, 0.7F);
            matrixStackIn.translate(0.0D, 1.0D, 0.0D);
         }

         if (entitylivingbaseIn instanceof VillagerEntity || entitylivingbaseIn instanceof ZombieVillagerEntity) {
            matrixStackIn.translate(0.0D, 0.1875D, 0.0D);
         }

         float ticksExisted = entitylivingbaseIn.ticksExisted + partialTicks;
         matrixStackIn.rotate(Vector3f.YP.rotation(ticksExisted * 0.05f));
         matrixStackIn.translate(0, (MathHelper.sin(ticksExisted * 0.06f) - 7) * 0.125, 0);

         crown.render(matrixStackIn, ItemRenderer.getArmorVertexBuilder(bufferIn, RenderType.getArmorCutoutNoCull(TEXTURE), false, enchanted), packedLightIn, OverlayTexture.NO_OVERLAY, 1.0f, 1.0f, 1.0f, 1.0f);
         matrixStackIn.pop();
      }
   }
}
