package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.layers.GlowingEyesLayer;
import birsy.goblinsmod.client.render.entity.model.CobuntoModel;
import birsy.goblinsmod.common.entity.CobuntoEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CobuntoRenderer extends MobRenderer<CobuntoEntity, CobuntoModel<CobuntoEntity>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/cobunto/cobunto.png");
	protected static final ResourceLocation EYE_TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/cobunto/cobunto_eyes.png");

	public CobuntoRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CobuntoModel<>(), 1.5F);
		this.addLayer(new GlowingEyesLayer<CobuntoEntity, CobuntoModel<CobuntoEntity>>(this, EYE_TEXTURE, 1.0F, 1.0F));
	}

	@Override
	public ResourceLocation getEntityTexture(CobuntoEntity entity) {
		return TEXTURE;
	}

}
