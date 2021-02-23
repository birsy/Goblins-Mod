package birsy.goblinsmod.client.render.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.AbstractEyesLayer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class GlowingEyesLayer<T extends Entity, M extends EntityModel<T>> extends AbstractEyesLayer<T, M> {
	private static float maximumOpacity;
	private static float minimumOpacity;
	private static ResourceLocation eyeTexture;
	private static RenderType renderType;
	
	public GlowingEyesLayer(IEntityRenderer<T, M> rendererIn, ResourceLocation eyeTextureIn, float minimumOpacityIn, float maximumOpacityIn) {
		super(rendererIn);
		maximumOpacity = maximumOpacityIn;
		minimumOpacity = minimumOpacityIn;
		eyeTexture = eyeTextureIn;
		renderType = RenderType.getEyes(eyeTexture);
	}

  	@Override
  	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(eyeTexture));
  		float fade = (0.5F * MathHelper.sin(entitylivingbaseIn.ticksExisted)) + 0.5F;
  		this.getEntityModel().render(matrixStackIn, ivertexbuilder, 15728640, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
  	}

	public RenderType getRenderType() {
		return renderType;
	}
}
