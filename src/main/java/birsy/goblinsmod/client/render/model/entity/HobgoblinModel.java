package birsy.goblinsmod.client.render.model.entity;

import birsy.goblinsmod.client.render.model.BirsyBaseModel;
import birsy.goblinsmod.client.render.model.BirsyModelRenderer;
import birsy.goblinsmod.common.entity.HobgoblinEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class HobgoblinModel<T extends HobgoblinEntity> extends BirsyBaseModel<T> {
    public BirsyModelRenderer hobgoblinBody;
    public BirsyModelRenderer hobgoblinHead;
    public BirsyModelRenderer hobgoblinUpperRightArm;
    public BirsyModelRenderer hobgoblinUpperLeftArm;
    public BirsyModelRenderer hobgoblinRightLeg;
    public BirsyModelRenderer hobgoblinLeftLeg;
    public BirsyModelRenderer hobgoblinJaw;
    public BirsyModelRenderer hobgoblinRightEar;
    public BirsyModelRenderer hobgoblinLeftEar;
    public BirsyModelRenderer hobgoblinTopNose;
    public BirsyModelRenderer hobgoblinForehead;
    public BirsyModelRenderer hobgoblinSideburns;
    public BirsyModelRenderer hobgoblinBeard;
    public BirsyModelRenderer hobgoblinBottomNose;
    public BirsyModelRenderer hobgoblinLowerRightArm;
    public BirsyModelRenderer hobgoblinRightFist;
    public BirsyModelRenderer hobgoblinLowerLeftArm;
    public BirsyModelRenderer hobgoblinLeftFist;

    public HobgoblinModel() {
        this.textureWidth = 128;
        this.textureHeight = 256;
        this.hobgoblinHead = new BirsyModelRenderer(this, 0, 0);
        this.hobgoblinHead.setRotationPoint(0.0F, -12.0F, -3.0F);
        this.hobgoblinHead.addBox(-13.5F, -27.0F, -11.5F, 27.0F, 27.0F, 23.0F, 0.0F, 0.0F, 0.0F);
        this.hobgoblinRightLeg = new BirsyModelRenderer(this, 88, 95);
        this.hobgoblinRightLeg.setRotationPoint(-9.0F, 5.5F, 0.0F);
        this.hobgoblinRightLeg.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.hobgoblinLeftLeg = new BirsyModelRenderer(this, 108, 95);
        this.hobgoblinLeftLeg.setRotationPoint(9.0F, 5.5F, 0.0F);
        this.hobgoblinLeftLeg.addBox(-2.5F, 0.0F, -2.5F, 5.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.hobgoblinLowerLeftArm = new BirsyModelRenderer(this, 92, 59);
        this.hobgoblinLowerLeftArm.mirror = true;
        this.hobgoblinLowerLeftArm.setRotationPoint(3.0F, 14.0F, 2.5F);
        this.hobgoblinLowerLeftArm.addBox(-3.0F, -5.0F, -12.0F, 6.0F, 5.0F, 12.0F, -0.05F, 0.0F, -0.05F);
        this.setRotateAngle(hobgoblinLowerLeftArm, 0.5082398928281348F, 0.0F, 0.0F);
        this.hobgoblinRightEar = new BirsyModelRenderer(this, 0, 0);
        this.hobgoblinRightEar.setRotationPoint(-13.5F, -14.0F, 0.0F);
        this.hobgoblinRightEar.addBox(-0.0F, -5.0F, 0.0F, 1.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hobgoblinRightEar, 0.0F, -1.0471975511965976F, 0.0F);
        this.hobgoblinForehead = new BirsyModelRenderer(this, 0, 50);
        this.hobgoblinForehead.setRotationPoint(0.0F, -27.0F, 0.0F);
        this.hobgoblinForehead.addBox(-9.5F, -4.0F, -7.5F, 19.0F, 4.0F, 15.0F, 0.0F, 0.0F, 0.0F);
        this.hobgoblinBody = new BirsyModelRenderer(this, 0, 106);
        this.hobgoblinBody.setRotationPoint(0.0F, 6.5F, 0.0F);
        this.hobgoblinBody.addBox(-13.5F, -12.0F, -6.6F, 27.0F, 17.0F, 13.0F, 0.49F, 0.5F, 0.5F);
        this.hobgoblinUpperLeftArm = new BirsyModelRenderer(this, 100, 17);
        this.hobgoblinUpperLeftArm.mirror = true;
        this.hobgoblinUpperLeftArm.setRotationPoint(14.0F, -8.0F, 0.0F);
        this.hobgoblinUpperLeftArm.addBox(0.0F, -3.0F, -2.5F, 6.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.hobgoblinBeard = new BirsyModelRenderer(this, 0, 87);
        this.hobgoblinBeard.setRotationPoint(0.0F, 0.0F, -4.5F);
        this.hobgoblinBeard.addBox(-13.5F, 0.0F, -9.0F, 27.0F, 10.0F, 9.0F, -0.5F, 0.0F, -0.5F);
        this.hobgoblinBottomNose = new BirsyModelRenderer(this, 77, 0);
        this.hobgoblinBottomNose.setRotationPoint(0.0F, 4.0F, 1.0F);
        this.hobgoblinBottomNose.addBox(-4.5F, 0.0F, -6.0F, 9.0F, 11.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hobgoblinBottomNose, 0.2617993877991494F, 0.0F, 0.0F);
        this.hobgoblinTopNose = new BirsyModelRenderer(this, 107, 0);
        this.hobgoblinTopNose.setRotationPoint(0.0F, -18.0F, -11.5F);
        this.hobgoblinTopNose.addBox(-2.5F, 0.0F, -2.0F, 5.0F, 5.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hobgoblinTopNose, -0.19198621771937624F, 0.0F, 0.0F);
        this.hobgoblinSideburns = new BirsyModelRenderer(this, 53, 50);
        this.hobgoblinSideburns.setRotationPoint(0.0F, -4.0F, 0.0F);
        this.hobgoblinSideburns.addBox(-15.5F, -4.0F, -0.5F, 31.0F, 8.0F, 1.0F, 0.0F, -0.2F, 0.0F);
        this.setRotateAngle(hobgoblinSideburns, -0.5082398928281348F, 0.0F, 0.0F);
        this.hobgoblinLeftEar = new BirsyModelRenderer(this, 0, 0);
        this.hobgoblinLeftEar.mirror = true;
        this.hobgoblinLeftEar.setRotationPoint(13.5F, -14.0F, 0.0F);
        this.hobgoblinLeftEar.addBox(-1.0F, -5.0F, 0.0F, 1.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hobgoblinLeftEar, 0.0F, 1.0471975511965976F, 0.0F);
        this.hobgoblinLeftFist = new BirsyModelRenderer(this, 92, 76);
        this.hobgoblinLeftFist.mirror = true;
        this.hobgoblinLeftFist.setRotationPoint(0.0F, -2.5F, -12.0F);
        this.hobgoblinLeftFist.addBox(-5.5F, -5.0F, -9.0F, 9.0F, 10.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hobgoblinLeftFist, -0.17453292519943295F, 0.2617993877991494F, 0.0F);
        this.hobgoblinRightFist = new BirsyModelRenderer(this, 92, 76);
        this.hobgoblinRightFist.setRotationPoint(0.0F, -2.5F, -12.0F);
        this.hobgoblinRightFist.addBox(-3.5F, -5.0F, -9.0F, 9.0F, 10.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hobgoblinRightFist, -0.17453292519943295F, -0.2617993877991494F, 0.0F);
        this.hobgoblinLowerRightArm = new BirsyModelRenderer(this, 92, 59);
        this.hobgoblinLowerRightArm.setRotationPoint(-3.0F, 14.0F, 2.5F);
        this.hobgoblinLowerRightArm.addBox(-3.0F, -5.0F, -12.0F, 6.0F, 5.0F, 12.0F, -0.05F, 0.0F, -0.05F);
        this.setRotateAngle(hobgoblinLowerRightArm, 0.5082398928281348F, 0.0F, 0.0F);
        this.hobgoblinUpperRightArm = new BirsyModelRenderer(this, 100, 17);
        this.hobgoblinUpperRightArm.setRotationPoint(-14.0F, -8.0F, 0.0F);
        this.hobgoblinUpperRightArm.addBox(-6.0F, -3.0F, -2.5F, 6.0F, 17.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.hobgoblinJaw = new BirsyModelRenderer(this, 0, 69);
        this.hobgoblinJaw.setRotationPoint(0.0F, 0.02F, 1.5F);
        this.hobgoblinJaw.addBox(-13.5F, -5.0F, -13.0F, 27.0F, 5.0F, 13.0F, 0.5F, 0.0F, 0.5F);
        this.hobgoblinBody.addChild(this.hobgoblinHead);
        this.hobgoblinBody.addChild(this.hobgoblinRightLeg);
        this.hobgoblinBody.addChild(this.hobgoblinLeftLeg);
        this.hobgoblinUpperLeftArm.addChild(this.hobgoblinLowerLeftArm);
        this.hobgoblinHead.addChild(this.hobgoblinRightEar);
        this.hobgoblinHead.addChild(this.hobgoblinForehead);
        this.hobgoblinBody.addChild(this.hobgoblinUpperLeftArm);
        this.hobgoblinJaw.addChild(this.hobgoblinBeard);
        this.hobgoblinTopNose.addChild(this.hobgoblinBottomNose);
        this.hobgoblinHead.addChild(this.hobgoblinTopNose);
        this.hobgoblinHead.addChild(this.hobgoblinSideburns);
        this.hobgoblinHead.addChild(this.hobgoblinLeftEar);
        this.hobgoblinLowerLeftArm.addChild(this.hobgoblinLeftFist);
        this.hobgoblinLowerRightArm.addChild(this.hobgoblinRightFist);
        this.hobgoblinUpperRightArm.addChild(this.hobgoblinLowerRightArm);
        this.hobgoblinBody.addChild(this.hobgoblinUpperRightArm);
        this.hobgoblinHead.addChild(this.hobgoblinJaw);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.hobgoblinBody).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

        float f = limbSwing;
        float f1 = limbSwingAmount;

        float globalSpeed = 1.0F;
        float globalHeight = 1.0F;
        float globalDegree = 1.0F;

        float walkSpeed = 0.75f * globalSpeed;

        if (entityIn.attackTick > 0) {
            swing(this.hobgoblinUpperRightArm, 2.0F, 0.1f * globalDegree, false, 0.2F, 0.3F, ageInTicks / 3.1831f, 0.5f, Axis.X);
        }

        resetParts(this.hobgoblinBody, this.hobgoblinHead, this.hobgoblinUpperRightArm, this.hobgoblinUpperLeftArm, this.hobgoblinRightLeg, this.hobgoblinLeftLeg, this.hobgoblinJaw, this.hobgoblinRightEar, this.hobgoblinLeftEar, this.hobgoblinTopNose, this.hobgoblinForehead, this.hobgoblinSideburns, this.hobgoblinBeard, this.hobgoblinBottomNose, this.hobgoblinLowerRightArm, this.hobgoblinRightFist, this.hobgoblinLowerLeftArm, this.hobgoblinLeftFist);

        //WALK
        swingLimbs(this.hobgoblinLeftLeg, this.hobgoblinRightLeg, walkSpeed, globalDegree, 0.0F, 0.0F, f, f1);
        swingLimbs(this.hobgoblinUpperRightArm, this.hobgoblinUpperLeftArm, walkSpeed, 0.3f * globalDegree, 0.0F, 0.0F, f, f1);

        swing(this.hobgoblinUpperRightArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.2F, f, f1, Axis.Z);
        swing(this.hobgoblinUpperLeftArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, -0.2F, f, f1, Axis.Z);

        swing(this.hobgoblinUpperRightArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Y);
        swing(this.hobgoblinUpperLeftArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, -0.0F, f, f1, Axis.Y);
        swing(this.hobgoblinLowerRightArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Y);
        swing(this.hobgoblinLowerLeftArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, -0.0F, f, f1, Axis.Y);

        bob(this.hobgoblinUpperRightArm, walkSpeed * 2.0f, 3 * globalHeight, true, f, f1, true);
        bob(this.hobgoblinUpperLeftArm, walkSpeed * 2.0f, 3 * globalHeight, true, f, f1, true);

        swing(this.hobgoblinHead, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Z);
        bob(this.hobgoblinHead, 2.0F * walkSpeed, 2 * globalHeight, true, f, f1, true);

        bob(this.hobgoblinTopNose, walkSpeed * 2.0f, 0.25f * globalHeight, true, f, f1, true);
        bob(this.hobgoblinBottomNose, walkSpeed * 2.0f, 0.25f * globalHeight, false, f, f1, true);

        swing(this.hobgoblinBody, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Z);
        swing(this.hobgoblinBody, 0.5F * walkSpeed, 0.1f * globalDegree, false, 0.2F, 0.0F, f, f1, Axis.Y);
        bob(this.hobgoblinBody, 2.0F * walkSpeed, 2 * globalHeight, true, f, f1, true);

        swing(this.hobgoblinJaw, walkSpeed, 0.5f * globalDegree, false, 0.0F, 0.3F, f, f1, Axis.X);

        if (entityIn.attackTick > 0) {
            swing(this.hobgoblinUpperRightArm, 2.0F, 0.1f * globalDegree, false, 0.2F, 0.3F, ageInTicks / 3.1831f, 0.5f, Axis.X);
        }

        //IDLE
        bob(this.hobgoblinHead, 0.25F * globalSpeed, 2 * globalHeight, false, ageInTicks, 0.5F, true);

        swing(this.hobgoblinUpperRightArm, 0.125F * globalSpeed, 0.1f * globalDegree, false, 0.5F, 0.07F, ageInTicks, 0.5F, Axis.Z);
        swing(this.hobgoblinUpperLeftArm, 0.125F * globalSpeed, 0.1f * globalDegree, false, 1.5F, -0.07F, ageInTicks, 0.5F, Axis.Z);
        swing(this.hobgoblinUpperRightArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 0.5F, 0.0F, ageInTicks, 0.5F, Axis.X);
        swing(this.hobgoblinUpperLeftArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.0F, ageInTicks, 0.5F, Axis.X);

        swing(this.hobgoblinLowerRightArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 0.5F, 0.0F, ageInTicks, 0.5F, Axis.X);
        swing(this.hobgoblinLowerLeftArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.0F, ageInTicks, 0.5F, Axis.X);
        swing(this.hobgoblinUpperRightArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 0.5F, 0.1F, ageInTicks, 0.5F, Axis.Y);
        swing(this.hobgoblinUpperLeftArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.1F, ageInTicks, 0.5F, Axis.Y);

        bob(this.hobgoblinUpperRightArm, 0.12F * globalSpeed, globalHeight, false, ageInTicks, 0.5F, true);
        bob(this.hobgoblinUpperLeftArm, 0.12F * globalSpeed, globalHeight, false, ageInTicks, 0.5F, true);

        swing(this.hobgoblinJaw, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.1F, ageInTicks, 0.5F, Axis.X);

        bob(this.hobgoblinHead, 0.12F * globalSpeed, globalHeight, false, ageInTicks, 0.5F, true);

        bob(this.hobgoblinBody, 0.12F * globalSpeed, 0.5f * globalHeight, false, ageInTicks, 0.5F, true);

        if (entityIn.attackTick > 0) {
            swing(this.hobgoblinUpperRightArm, 2.0F, 0.1f * globalDegree, false, 0.2F, 0.3F, ageInTicks / 3.1831f, 0.5f, Axis.X);
        }

        look(this.hobgoblinBody, netHeadYaw, headPitch, 10.0F, 3.0F);
        look(this.hobgoblinHead, netHeadYaw, headPitch, 1.0F, 1.0F);
    }

    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        super.setLivingAnimations(entityIn, limbSwing, limbSwingAmount, partialTick);

        int i = entityIn.getAttackTick();
        if (i > 0) {
            this.hobgoblinUpperRightArm.rotateAngleX =+ -2.0F + 1.5F * MathHelper.func_233021_e_((float) i, 10.0F);
            this.hobgoblinUpperLeftArm.rotateAngleX =+ -2.0F + 1.5F * MathHelper.func_233021_e_((float) i, 10.0F);
        }
    }
}
