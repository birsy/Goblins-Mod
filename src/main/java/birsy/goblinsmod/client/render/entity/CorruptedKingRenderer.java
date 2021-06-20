package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.model.CorruptedKingModel;
import birsy.goblinsmod.common.entity.boss.king_boss.CorruptedKingEntity;
import birsy.goblinsmod.core.GoblinsMod;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class CorruptedKingRenderer extends MobRenderer<CorruptedKingEntity, CorruptedKingModel<CorruptedKingEntity>> {
	private static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/king_boss/corrupted_king.png");

	public CorruptedKingRenderer(EntityRendererManager renderManagerIn) {
		super(renderManagerIn, new CorruptedKingModel<>(), 2.0F);
	}

	@Override
	public ResourceLocation getEntityTexture(CorruptedKingEntity entity) {
		return TEXTURE;
	}

}
