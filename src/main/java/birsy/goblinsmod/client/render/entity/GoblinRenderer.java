package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.model.entity.GoblinModel;
import birsy.goblinsmod.client.render.model.entity.HobgoblinModel;
import birsy.goblinsmod.common.entity.GoblinEntity;
import birsy.goblinsmod.common.entity.HobgoblinEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HeldItemLayer;
import net.minecraft.util.ResourceLocation;

public class GoblinRenderer extends MobRenderer<GoblinEntity, GoblinModel<GoblinEntity>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/goblin/goblin.png");

	public GoblinRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new GoblinModel<>(), 1.5F);
		this.addLayer(new HeldItemLayer<>(this));
	}

	@Override
	public ResourceLocation getEntityTexture(GoblinEntity entity) {
		return TEXTURE;
	}

}
