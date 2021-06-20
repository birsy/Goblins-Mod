package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.client.render.util.BirsyBaseModel;
import birsy.goblinsmod.client.render.util.BirsyModelRenderer;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class UrklingModel<T extends Entity> extends BirsyBaseModel<T> {
    public BirsyModelRenderer urklingBody;
    public BirsyModelRenderer urklingRightArm;
    public BirsyModelRenderer urklingLeftArm;
    public BirsyModelRenderer urklingRightStrings;
    public BirsyModelRenderer urklingHead;
    public BirsyModelRenderer urklingLeftStrings;
    public BirsyModelRenderer legsJoint;
    public BirsyModelRenderer urklingNose;
    public BirsyModelRenderer urklingJaw;
    public BirsyModelRenderer urklingLeftEar;
    public BirsyModelRenderer urklingRightEar;
    public BirsyModelRenderer urklingRightLeg;
    public BirsyModelRenderer urklingLeftLeg;

    public UrklingModel() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.urklingRightArm = new BirsyModelRenderer(this, 46, 8);
        this.urklingRightArm.setRotationPoint(-8.0F, 10.0F, 0.0F);
        this.urklingRightArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.urklingJaw = new BirsyModelRenderer(this, 32, 4);
        this.urklingJaw.setRotationPoint(0.0F, 0.05F, -1.5F);
        this.urklingJaw.addBox(-4.5F, -2.0F, -2.0F, 9.0F, 2.0F, 2.0F, 0.25F, 0.0F, 0.25F);
        this.legsJoint = new BirsyModelRenderer(this, 0, 0);
        this.legsJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.legsJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.urklingRightLeg = new BirsyModelRenderer(this, 38, 8);
        this.urklingRightLeg.setRotationPoint(-5.0F, 0.0F, 0.0F);
        this.urklingRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.urklingHead = new BirsyModelRenderer(this, 0, 0);
        this.urklingHead.setRotationPoint(0.0F, -10.0F, -1.0F);
        this.urklingHead.addBox(-4.5F, -7.0F, -3.5F, 9.0F, 7.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.urklingNose = new BirsyModelRenderer(this, 0, 0);
        this.urklingNose.setRotationPoint(0.0F, -4.5F, -3.5F);
        this.urklingNose.addBox(-0.5F, -0.5F, -1.5F, 1.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(urklingNose, 0.11728612207217244F, 0.0F, 0.0F);
        this.urklingLeftLeg = new BirsyModelRenderer(this, 38, 8);
        this.urklingLeftLeg.mirror = true;
        this.urklingLeftLeg.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.urklingLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.urklingLeftEar = new BirsyModelRenderer(this, 25, 0);
        this.urklingLeftEar.setRotationPoint(4.5F, -5.0F, 0.0F);
        this.urklingLeftEar.addBox(-0.5F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(urklingLeftEar, 0.0F, 0.0F, -0.41887902047863906F);
        this.urklingBody = new BirsyModelRenderer(this, 0, 14);
        this.urklingBody.setRotationPoint(0.0F, 18.0F, 0.0F);
        this.urklingBody.addBox(-7.5F, -10.0F, -4.0F, 15.0F, 10.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.urklingLeftStrings = new BirsyModelRenderer(this, 35, 0);
        this.urklingLeftStrings.mirror = true;
        this.urklingLeftStrings.setRotationPoint(3.5F, 0.0F, 0.0F);
        this.urklingLeftStrings.addBox(-3.5F, -0.25F, -0.5F, 7.0F, 3.0F, 1.0F, -0.1F, 0.0F, 3.0F);
        this.urklingRightEar = new BirsyModelRenderer(this, 25, 0);
        this.urklingRightEar.mirror = true;
        this.urklingRightEar.setRotationPoint(-4.5F, -5.0F, 0.0F);
        this.urklingRightEar.addBox(-3.5F, -1.0F, -0.5F, 4.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(urklingRightEar, 0.0F, 0.0F, 0.41887902047863906F);
        this.urklingLeftArm = new BirsyModelRenderer(this, 46, 8);
        this.urklingLeftArm.mirror = true;
        this.urklingLeftArm.setRotationPoint(8.0F, 10.0F, 0.0F);
        this.urklingLeftArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 13.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.urklingRightStrings = new BirsyModelRenderer(this, 35, 0);
        this.urklingRightStrings.setRotationPoint(-3.5F, 0.0F, 0.0F);
        this.urklingRightStrings.addBox(-3.5F, -0.25F, -0.5F, 7.0F, 3.0F, 1.0F, -0.1F, 0.0F, 3.0F);
        this.urklingHead.addChild(this.urklingJaw);
        this.urklingBody.addChild(this.legsJoint);
        this.legsJoint.addChild(this.urklingRightLeg);
        this.urklingBody.addChild(this.urklingHead);
        this.urklingHead.addChild(this.urklingNose);
        this.legsJoint.addChild(this.urklingLeftLeg);
        this.urklingHead.addChild(this.urklingLeftEar);
        this.urklingBody.addChild(this.urklingLeftStrings);
        this.urklingHead.addChild(this.urklingRightEar);
        this.urklingBody.addChild(this.urklingRightStrings);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.urklingRightArm, this.urklingBody, this.urklingLeftArm).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}
}
