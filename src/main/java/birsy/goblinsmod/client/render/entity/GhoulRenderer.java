package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.model.GhoulModel;
import birsy.goblinsmod.common.entity.GhoulEntity;
import birsy.goblinsmod.core.GoblinsMod;
import birsy.goblinsmod.core.util.MathUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class GhoulRenderer extends MobRenderer<GhoulEntity, GhoulModel<GhoulEntity>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/lich/ghoul.png");

	public GhoulRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GhoulModel<>(), 0.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(GhoulEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(GhoulEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();

		if (entityIn.getEmergingTicks(partialTicks) > 0) {
			float emergingFactor = MathUtils.bias(entityIn.getEmergingTicksNormalized(partialTicks), 0.5f);

			matrixStackIn.rotate(Vector3f.ZP.rotation(emergingFactor * MathHelper.sin(entityIn.ticksExisted + partialTicks) * 0.25f));
			matrixStackIn.rotate(Vector3f.YP.rotation(emergingFactor * MathHelper.sin(entityIn.ticksExisted + partialTicks) * 0.5f));
			matrixStackIn.rotate(Vector3f.XP.rotation((float) Math.toRadians(emergingFactor * 22.5)));

			matrixStackIn.translate(0, emergingFactor * -2, 0);
		}

		matrixStackIn.scale(entityIn.getSize(), entityIn.getSize(), entityIn.getSize());

		this.entityModel.setRGB(entityIn.getRed(), entityIn.getGreen(), entityIn.getBlue());
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);

		matrixStackIn.pop();
	}
}
