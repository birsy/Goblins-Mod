package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.layers.SanctumiteGhostLayer;
import birsy.goblinsmod.client.render.entity.model.SanctumiteModel;
import birsy.goblinsmod.common.entity.SanctumiteEntity;
import birsy.goblinsmod.core.GoblinsMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nullable;

public class SanctumiteRenderer extends MobRenderer<SanctumiteEntity, SanctumiteModel<SanctumiteEntity>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/sanctumite/sanctumite.png");
	protected static final ResourceLocation EYE_TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/sanctumite/sanctumite_eyes.png");

	public SanctumiteRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SanctumiteModel<>(), 1.0F);
		this.addLayer(new SanctumiteGhostLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(SanctumiteEntity entity) {
		return TEXTURE;
	}

	@Override
	protected RenderType func_230496_a_(SanctumiteEntity p_230496_1_, boolean p_230496_2_, boolean p_230496_3_, boolean p_230496_4_) {
		return RenderType.getEntityTranslucent(TEXTURE);
	}
}
