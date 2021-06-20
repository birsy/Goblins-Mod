package birsy.goblinsmod.client.render.entity;

import birsy.goblinsmod.client.render.entity.model.HobgoblinModel;
import birsy.goblinsmod.common.entity.HobgoblinEntity;
import birsy.goblinsmod.core.GoblinsMod;
import birsy.goblinsmod.core.util.MathUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.renderer.IRenderTypeBuffer;
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

	@Override
	public void render(HobgoblinEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		float leftArmRotation = entityIn.getLeftAttackTicks(partialTicks);
		float rightArmRotation = entityIn.getRightAttackTicks(partialTicks);

		if (entityIn.isChargingLeftArmAttack()) {
			leftArmRotation = leftArmRotation / entityIn.leftArmWindupTime;
		} else {
			leftArmRotation = leftArmRotation / entityIn.slamWindupTime;
		}
		leftArmRotation = MathUtils.bias(leftArmRotation, -0.5f);

		if (entityIn.isChargingRightArmAttack()) {
			rightArmRotation = rightArmRotation / entityIn.rightArmWindupTime;
		} else {
			rightArmRotation = rightArmRotation / entityIn.slamWindupTime;
		}
		rightArmRotation = MathUtils.bias(rightArmRotation, -0.5f);

		this.getEntityModel().setArmRotation(leftArmRotation * -2.2F, rightArmRotation * -2.2F);
		super.render(entityIn, entityYaw, partialTicks, matrixStackIn, bufferIn, packedLightIn);
	}
}
