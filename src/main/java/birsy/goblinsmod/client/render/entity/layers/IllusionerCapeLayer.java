package birsy.goblinsmod.client.render.entity.layers;

import birsy.goblinsmod.client.render.entity.model.IllusionerCapeModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.IllagerModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class IllusionerCapeLayer<T extends IllusionerEntity, M extends IllagerModel<T>> extends LayerRenderer<T, M> {
   public double prevChasingPosX;
   public double prevChasingPosY;
   public double prevChasingPosZ;
   public double chasingPosX;
   public double chasingPosY;
   public double chasingPosZ;

   private static final IllusionerCapeModel capeModel = new IllusionerCapeModel();
   private static final ResourceLocation TEXTURE = new ResourceLocation("minecraft", "textures/entity/illager/illusioner_cape.png");

   public IllusionerCapeLayer(IEntityRenderer<T, M> illusionerModelIn) {
      super(illusionerModelIn);
   }

   public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
      updateCape(entitylivingbaseIn);
      
      matrixStackIn.push();
      matrixStackIn.translate(0.0D, 0.0D, 0.125D);
      double d0 = MathHelper.lerp((double)partialTicks, this.prevChasingPosX, this.chasingPosX) - MathHelper.lerp((double)partialTicks, entitylivingbaseIn.prevPosX, entitylivingbaseIn.getPosX());
      double d1 = MathHelper.lerp((double)partialTicks, this.prevChasingPosY, this.chasingPosY) - MathHelper.lerp((double)partialTicks, entitylivingbaseIn.prevPosY, entitylivingbaseIn.getPosY());
      double d2 = MathHelper.lerp((double)partialTicks, this.prevChasingPosZ, this.chasingPosZ) - MathHelper.lerp((double)partialTicks, entitylivingbaseIn.prevPosZ, entitylivingbaseIn.getPosZ());
      float f = entitylivingbaseIn.prevRenderYawOffset + (entitylivingbaseIn.renderYawOffset - entitylivingbaseIn.prevRenderYawOffset);
      double d3 = (double)MathHelper.sin(f * ((float)Math.PI / 180F));
      double d4 = (double)(-MathHelper.cos(f * ((float)Math.PI / 180F)));
      float f1 = (float)d1 * 10.0F;
      f1 = MathHelper.clamp(f1, -6.0F, 32.0F);
      float f2 = (float)(d0 * d3 + d2 * d4) * 100.0F;
      f2 = MathHelper.clamp(f2, 0.0F, 150.0F);
      float f3 = (float)(d0 * d4 - d2 * d3) * 100.0F;
      f3 = MathHelper.clamp(f3, -20.0F, 20.0F);
      if (f2 < 0.0F) {
         f2 = 0.0F;
      }

      f1 = f1 + MathHelper.sin(MathHelper.lerp(partialTicks, entitylivingbaseIn.prevDistanceWalkedModified, entitylivingbaseIn.distanceWalkedModified) * 6.0F) * 32.0F;
      if (entitylivingbaseIn.isCrouching()) {
         f1 += 25.0F;
      }

      matrixStackIn.rotate(Vector3f.XP.rotationDegrees(6.0F + f2 / 2.0F + f1));
      matrixStackIn.rotate(Vector3f.ZP.rotationDegrees(f3 / 2.0F));
      matrixStackIn.rotate(Vector3f.YP.rotationDegrees(180.0F - f3 / 2.0F));
      IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntitySolid(TEXTURE));
      capeModel.render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
      matrixStackIn.pop();
   }

   private void updateCape(T entityIn) {
      this.prevChasingPosX = this.chasingPosX;
      this.prevChasingPosY = this.chasingPosY;
      this.prevChasingPosZ = this.chasingPosZ;
      double d0 = entityIn.getPosX() - this.chasingPosX;
      double d1 = entityIn.getPosY() - this.chasingPosY;
      double d2 = entityIn.getPosZ() - this.chasingPosZ;
      double d3 = 10.0D;
      if (d0 > 10.0D) {
         this.chasingPosX = entityIn.getPosX();
         this.prevChasingPosX = this.chasingPosX;
      }

      if (d2 > 10.0D) {
         this.chasingPosZ = entityIn.getPosZ();
         this.prevChasingPosZ = this.chasingPosZ;
      }

      if (d1 > 10.0D) {
         this.chasingPosY = entityIn.getPosY();
         this.prevChasingPosY = this.chasingPosY;
      }

      if (d0 < -10.0D) {
         this.chasingPosX = entityIn.getPosX();
         this.prevChasingPosX = this.chasingPosX;
      }

      if (d2 < -10.0D) {
         this.chasingPosZ = entityIn.getPosZ();
         this.prevChasingPosZ = this.chasingPosZ;
      }

      if (d1 < -10.0D) {
         this.chasingPosY = entityIn.getPosY();
         this.prevChasingPosY = this.chasingPosY;
      }

      this.chasingPosX += d0 * 0.25D;
      this.chasingPosZ += d2 * 0.25D;
      this.chasingPosY += d1 * 0.25D;
   }
}
