package birsy.goblinsmod.client.render.model.entity;

import birsy.goblinsmod.client.render.model.BirsyBaseModel;
import birsy.goblinsmod.client.render.model.BirsyModelRenderer;
import birsy.goblinsmod.common.entity.GoblinEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.IHasArm;
import net.minecraft.client.renderer.entity.model.IHasHead;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.HandSide;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * BigGoblinModel - birse
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class GoblinModel<T extends GoblinEntity> extends BirsyBaseModel<T> implements IHasHead, IHasArm {
    public BirsyModelRenderer goblinWaist;
    public BirsyModelRenderer goblinLeftArm;
    public BirsyModelRenderer goblinRightArm;
    public BirsyModelRenderer goblinChest;
    public BirsyModelRenderer goblinRightLeg;
    public BirsyModelRenderer goblinLeftLeg;
    public BirsyModelRenderer headJoint;
    public BirsyModelRenderer goblinShirt;
    public BirsyModelRenderer goblinHead;
    public BirsyModelRenderer goblinJaw;
    public BirsyModelRenderer goblinLeftEar;
    public BirsyModelRenderer goblinRightEar;
    public BirsyModelRenderer goblinNose;

    public GoblinModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.goblinShirt = new BirsyModelRenderer(this, 0, 39);
        this.goblinShirt.setRotationPoint(0.0F, 0.0F, 1.0F);
        this.goblinShirt.addBox(-6.5F, 0.0F, -8.5F, 13.0F, 2.0F, 8.0F, -0.01F, 0.0F, 0.5F);
        this.setRotateAngle(goblinShirt, -0.08726646259971647F, 0.0F, 0.0F);
        this.goblinLeftEar = new BirsyModelRenderer(this, 26, 0);
        this.goblinLeftEar.setRotationPoint(-4.5F, -6.0F, -1.0F);
        this.goblinLeftEar.addBox(-4.0F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(goblinLeftEar, 0.0F, 0.39269908169872414F, 0.0F);
        this.goblinLeftLeg = new BirsyModelRenderer(this, 50, 0);
        this.goblinLeftLeg.setRotationPoint(3.5F, -1.5F, 0.0F);
        this.goblinLeftLeg.addBox(0.0F, -1.5F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.goblinLeftArm = new BirsyModelRenderer(this, 34, 5);
        this.goblinLeftArm.setRotationPoint(-6.5F, 4.0F, -0.5F);
        this.goblinLeftArm.addBox(-2.0F, -1.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.goblinRightLeg = new BirsyModelRenderer(this, 50, 0);
        this.goblinRightLeg.setRotationPoint(-3.5F, -1.5F, 0.0F);
        this.goblinRightLeg.addBox(-2.0F, -1.5F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.goblinJaw = new BirsyModelRenderer(this, 0, 17);
        this.goblinJaw.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.goblinJaw.addBox(-4.5F, -3.0F, -4.0F, 9.0F, 3.0F, 4.0F, 0.25F, 0.25F, 0.25F);
        this.setRotateAngle(goblinJaw, 0.11728612207217244F, 0.0F, 0.0F);
        this.goblinWaist = new BirsyModelRenderer(this, 0, 49);
        this.goblinWaist.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.goblinWaist.addBox(-4.5F, -8.0F, -3.5F, 9.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.goblinNose = new BirsyModelRenderer(this, 36, 0);
        this.goblinNose.setRotationPoint(0.0F, -6.0F, -4.0F);
        this.goblinNose.addBox(-1.5F, 0.0F, -1.5F, 3.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(goblinNose, -0.15812683755437926F, 0.0F, 0.0F);
        this.goblinRightArm = new BirsyModelRenderer(this, 42, 5);
        this.goblinRightArm.setRotationPoint(6.5F, 4.0F, -0.5F);
        this.goblinRightArm.addBox(0.0F, -1.0F, -1.0F, 2.0F, 16.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.goblinRightEar = new BirsyModelRenderer(this, 26, 0);
        this.goblinRightEar.mirror = true;
        this.goblinRightEar.setRotationPoint(4.5F, -6.0F, -1.0F);
        this.goblinRightEar.addBox(0.0F, -2.0F, 0.0F, 4.0F, 4.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(goblinRightEar, 0.0F, -0.39269908169872414F, 0.0F);
        this.goblinChest = new BirsyModelRenderer(this, 0, 23);
        this.goblinChest.setRotationPoint(0.0F, -8.0F, 3.5F);
        this.goblinChest.addBox(-6.5F, -7.0F, -8.0F, 13.0F, 7.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(goblinChest, 0.08726646259971647F, 0.0F, 0.0F);
        this.goblinHead = new BirsyModelRenderer(this, 0, 0);
        this.goblinHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.goblinHead.addBox(-4.5F, -9.0F, -4.0F, 9.0F, 9.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.headJoint = new BirsyModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, -7.0F, -5.5F);
        this.headJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(headJoint, -0.08726646259971647F, 0.0F, 0.0F);
        this.goblinChest.addChild(this.goblinShirt);
        this.goblinHead.addChild(this.goblinLeftEar);
        this.goblinWaist.addChild(this.goblinLeftLeg);
        this.goblinWaist.addChild(this.goblinRightLeg);
        this.goblinHead.addChild(this.goblinJaw);
        this.goblinHead.addChild(this.goblinNose);
        this.goblinHead.addChild(this.goblinRightEar);
        this.goblinWaist.addChild(this.goblinChest);
        this.headJoint.addChild(this.goblinHead);
        this.goblinChest.addChild(this.headJoint);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.goblinLeftArm, this.goblinWaist, this.goblinRightArm).forEach((BirsyModelRenderer) -> { 
            BirsyModelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        resetParts(goblinWaist, goblinLeftArm, goblinRightArm, goblinChest, goblinRightLeg, goblinLeftLeg, headJoint, goblinShirt, goblinHead, goblinJaw, goblinLeftEar, goblinRightEar, goblinNose);

        float f = limbSwing;
        float f1 = limbSwingAmount;

        float globalSpeed = 1.0F;
        float globalHeight = 0.5F;
        float globalDegree = 1.0F;

        float walkSpeed = 0.5f * globalSpeed;

        //WALK
        swingLimbs(this.goblinLeftLeg, this.goblinRightLeg, walkSpeed, globalDegree, 0.0F, 0.0F, f, f1);

        swing(this.goblinRightArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.2F, f, f1, Axis.Z);
        swing(this.goblinLeftArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, -0.2F, f, f1, Axis.Z);

        swing(this.goblinRightArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Y);
        swing(this.goblinLeftArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, -0.0F, f, f1, Axis.Y);
        swing(this.goblinRightArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Y);
        swing(this.goblinLeftArm, walkSpeed, 0.1f * globalDegree, false, 0.0F, -0.0F, f, f1, Axis.Y);

        bob(this.goblinRightArm, walkSpeed * 2.0f, 3 * globalHeight, true, f, f1, true);
        bob(this.goblinLeftArm, walkSpeed * 2.0f, 3 * globalHeight, true, f, f1, true);

        swing(this.goblinHead, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Z);
        bob(this.goblinHead, 2.0F * walkSpeed, 2 * globalHeight, true, f, f1, true);

        bob(this.goblinLeftEar, walkSpeed * 2.0f, 0.25f * globalHeight, true, f, f1, true);
        bob(this.goblinRightEar, walkSpeed * 2.0f, 0.25f * globalHeight, true, f, f1, true);
        bob(this.goblinNose, walkSpeed * 2.0f, 0.25f * globalHeight, false, f, f1, true);

        swing(this.goblinWaist, walkSpeed, 0.1f * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.X);
        swing(this.goblinWaist, 0.5F * walkSpeed, 0.1f * globalDegree, false, 0.2F, 0.0F, f, f1, Axis.Y);
        bob(this.goblinWaist, 2.0F * walkSpeed, 2 * globalHeight, true, f, f1, true);

        swing(this.goblinJaw, walkSpeed, 0.5f * globalDegree, false, 0.0F, 0.3F, f, f1, Axis.X);

        //IDLE
        bob(this.goblinHead, 0.25F * globalSpeed, 2 * globalHeight, false, ageInTicks, 0.5F, true);

        swing(this.goblinRightArm, 0.125F * globalSpeed, 0.1f * globalDegree, false, 0.5F, 0.07F, ageInTicks, 0.5F, Axis.Z);
        swing(this.goblinLeftArm, 0.125F * globalSpeed, 0.1f * globalDegree, false, 1.5F, -0.07F, ageInTicks, 0.5F, Axis.Z);
        swing(this.goblinRightArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 0.5F, 0.0F, ageInTicks, 0.5F, Axis.X);
        swing(this.goblinLeftArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.0F, ageInTicks, 0.5F, Axis.X);

        swing(this.goblinRightArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 0.5F, 0.1F, ageInTicks, 0.5F, Axis.Y);
        swing(this.goblinLeftArm, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.1F, ageInTicks, 0.5F, Axis.Y);

        bob(this.goblinRightArm, 0.12F * globalSpeed, globalHeight, false, ageInTicks, 0.5F, true);
        bob(this.goblinLeftArm, 0.12F * globalSpeed, globalHeight, false, ageInTicks, 0.5F, true);

        swing(this.goblinJaw, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.1F, ageInTicks, 0.5F, Axis.X);

        bob(this.goblinHead, 0.12F * globalSpeed, globalHeight, false, ageInTicks, 0.5F, true);

        bob(this.goblinWaist, 0.12F * globalSpeed, 0.5f * globalHeight, false, ageInTicks, 0.5F, true);

        look(this.goblinWaist, netHeadYaw, headPitch, 10.0F, 3.0F);
        look(this.goblinHead, netHeadYaw, headPitch, 1.0F, 1.0F);


        swingLimbs(this.goblinRightArm, this.goblinLeftArm, walkSpeed, globalDegree, 0.0F, 0.0F, f, f1);
    }

    @Override
    public ModelRenderer getModelHead() {
        return goblinHead;
    }

    public void translateHand(HandSide sideIn, MatrixStack matrixStackIn) {
        this.getArmForSide(sideIn).translateRotate(matrixStackIn);
    }

    protected ModelRenderer getArmForSide(HandSide side) {
        return side == HandSide.LEFT ? this.goblinLeftArm : this.goblinRightArm;
    }
}
