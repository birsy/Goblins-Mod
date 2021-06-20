package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.layers.GlowingEyesLayer;
import birsy.goblinsmod.client.render.entity.model.CobuntoModel;
import birsy.goblinsmod.common.entity.CobuntoEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BarnacleRenderer extends MobRenderer<CobuntoEntity, CobuntoModel<CobuntoEntity>> {
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/cobunto/cobunto.png");

	public BarnacleRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CobuntoModel<>(), 1.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(CobuntoEntity entity) {
		return TEXTURE;
	}
}
