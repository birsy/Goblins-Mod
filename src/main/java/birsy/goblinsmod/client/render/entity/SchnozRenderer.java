package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.layers.BlinkingEyesLayer;
import birsy.goblinsmod.client.render.entity.layers.GlowingEyesLayer;
import birsy.goblinsmod.client.render.entity.model.CobuntoModel;
import birsy.goblinsmod.client.render.entity.model.SchnozModel;
import birsy.goblinsmod.common.entity.CobuntoEntity;
import birsy.goblinsmod.common.entity.SchnozEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class SchnozRenderer extends MobRenderer<SchnozEntity, SchnozModel<SchnozEntity>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/schnoz/schnoz.png");
	protected static final ResourceLocation EYE_TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/schnoz/schnoz_eyes.png");

	public SchnozRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new SchnozModel<>(), 0.5F);
		this.addLayer(new BlinkingEyesLayer<>(this, EYE_TEXTURE, 50));
	}

	@Override
	public ResourceLocation getEntityTexture(SchnozEntity entity) {
		return TEXTURE;
	}

}
