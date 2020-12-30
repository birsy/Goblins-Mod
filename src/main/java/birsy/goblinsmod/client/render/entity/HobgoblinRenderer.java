package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.model.entity.HobgoblinModel;
import birsy.goblinsmod.common.entity.HobgoblinEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class HobgoblinRenderer extends MobRenderer<HobgoblinEntity, HobgoblinModel<HobgoblinEntity>>
{
	protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/goblin/hobgoblin.png");
	
	public HobgoblinRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new HobgoblinModel<>(), 1.5F);
	}

	@Override
	public ResourceLocation getEntityTexture(HobgoblinEntity entity) {
		return TEXTURE;
	}

}
