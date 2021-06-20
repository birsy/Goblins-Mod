package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.layers.GlowingEyesLayer;
import birsy.goblinsmod.client.render.entity.layers.SanctumiteGhostLayer;
import birsy.goblinsmod.client.render.entity.layers.WitherSkullGhostLayer;
import birsy.goblinsmod.client.render.entity.model.SanctumiteModel;
import birsy.goblinsmod.client.render.entity.model.WitherSkullModel;
import birsy.goblinsmod.common.entity.SanctumiteEntity;
import birsy.goblinsmod.common.entity.projectile.NewWitherSkullEntity;
import birsy.goblinsmod.core.GoblinsMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;

public class WitherSkullRenderer extends MobRenderer<NewWitherSkullEntity, WitherSkullModel<NewWitherSkullEntity>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/wither/wither.png");
	protected static final ResourceLocation EYE_TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/wither/wither_glow.png");

	public WitherSkullRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new WitherSkullModel<>(), 1.0F);
		this.addLayer(new WitherSkullGhostLayer<>(this));
		this.addLayer(new GlowingEyesLayer<>(this, EYE_TEXTURE, 1.0f, 1.0f));
	}

	@Override
	public ResourceLocation getEntityTexture(NewWitherSkullEntity entity) {
		return TEXTURE;
	}

	@Override
	public void render(NewWitherSkullEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		matrixStackIn.push();
		matrixStackIn.pop();
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
}
