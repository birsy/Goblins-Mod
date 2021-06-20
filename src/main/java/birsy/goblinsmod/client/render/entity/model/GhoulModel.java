package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.client.render.util.BirsyBaseModel;
import birsy.goblinsmod.client.render.util.BirsyModelRenderer;
import birsy.goblinsmod.common.entity.GhoulEntity;
import birsy.goblinsmod.core.util.MathUtils;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.util.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Random;

@OnlyIn(Dist.CLIENT)
public class GhoulModel<T extends GhoulEntity> extends BirsyBaseModel<T> {
    public BirsyModelRenderer rootJoint;
    public BirsyModelRenderer ghoulBody;
    public BirsyModelRenderer armsJoint;
    public BirsyModelRenderer legsJoint;
    public BirsyModelRenderer headJoint;
    public BirsyModelRenderer lookJoint;
    public BirsyModelRenderer ghoulRightArm;
    public BirsyModelRenderer ghoulLeftArm;
    public BirsyModelRenderer ghoulRightLeg;
    public BirsyModelRenderer ghoulLeftLeg;
    public BirsyModelRenderer ghoulHead;
    public BirsyModelRenderer ghoulDroop;

    private float armOffset = 0;

    private float red = 1.0f;
    private float green = 1.0f;
    private float blue = 1.0f;

    public GhoulModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;


        this.rootJoint = new BirsyModelRenderer(this, 0, 0);
        this.rootJoint.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.rootJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulBody = new BirsyModelRenderer(this, 0, 16);
        this.ghoulBody.setRotationPoint(0.0F, -16.0F, 0.0F);
        this.ghoulBody.addBox(-4.5F, -14.0F, -3.0F, 9.0F, 18.0F, 6.0F, 0.0F, 0.0F, 0.0F);


        this.headJoint = new BirsyModelRenderer(this, 0, 0);
        this.headJoint.setRotationPoint(0.0F, -20.0F, 0.0F);
        this.headJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

        this.lookJoint = new BirsyModelRenderer(this, 0, 0);
        this.lookJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.lookJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulHead = new BirsyModelRenderer(this, 0, 0);
        this.ghoulHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.ghoulHead.addBox(-4.5F, -4.0F, -4.0F, 9.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulDroop = new BirsyModelRenderer(this, 0, 40);
        this.ghoulDroop.setRotationPoint(0.0F, 2.5F, 0.0F);
        this.ghoulDroop.addBox(-4.0F, 0.0F, -3.5F, 8.0F, 8.0F, 7.0F, 0.0F, 0.0F, 0.0F);


        this.armsJoint = new BirsyModelRenderer(this, 0, 0);
        this.armsJoint.setRotationPoint(0.0F, -7.0F, 0.0F);
        this.armsJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulLeftArm = new BirsyModelRenderer(this, 30, 16);
        this.ghoulLeftArm.setRotationPoint(4.0F, 0.0F, 0.0F);
        this.ghoulLeftArm.addBox(0.0F, -1.5F, -1.5F, 3.0F, 18.0F, 3.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulRightArm = new BirsyModelRenderer(this, 30, 16);
        this.ghoulRightArm.mirror = true;
        this.ghoulRightArm.setRotationPoint(-4.0F, 0.0F, 0.0F);
        this.ghoulRightArm.addBox(-3.0F, -1.5F, -1.5F, 3.0F, 18.0F, 3.0F, 0.0F, 0.0F, 0.0F);


        this.legsJoint = new BirsyModelRenderer(this, 0, 0);
        this.legsJoint.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.legsJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulLeftLeg = new BirsyModelRenderer(this, 42, 16);
        this.ghoulLeftLeg.mirror = true;
        this.ghoulLeftLeg.setRotationPoint(2.5F, 0.0F, 0.0F);
        this.ghoulLeftLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulRightLeg = new BirsyModelRenderer(this, 42, 16);
        this.ghoulRightLeg.setRotationPoint(-2.5F, 0.0F, 0.0F);
        this.ghoulRightLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 12.0F, 2.0F, 0.0F, 0.0F, 0.0F);

        this.ghoulBody.addChild(this.legsJoint);
        this.ghoulBody.addChild(this.armsJoint);
        this.armsJoint.addChild(this.ghoulRightArm);
        this.rootJoint.addChild(this.ghoulBody);
        this.headJoint.addChild(this.lookJoint);
        this.lookJoint.addChild(this.ghoulHead);
        this.ghoulBody.addChild(this.headJoint);
        this.legsJoint.addChild(this.ghoulLeftLeg);
        this.legsJoint.addChild(this.ghoulRightLeg);
        this.armsJoint.addChild(this.ghoulLeftArm);
        this.ghoulHead.addChild(this.ghoulDroop);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        this.rootJoint.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn,
                MathHelper.clamp(red * this.red, 0, 1),
                MathHelper.clamp(green * this.green, 0, 1),
                MathHelper.clamp(blue * this.blue, 0, 1), alpha);
    }

    @Override
    public void setRotationAngles (T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        resetParts(rootJoint, ghoulBody, armsJoint, legsJoint, headJoint, ghoulRightArm, ghoulLeftArm, ghoulRightLeg, ghoulLeftLeg, ghoulHead, ghoulDroop);

        float f = ageInTicks;
        float f1 = 0.5f;

        float globalSpeed = 0.5F;
        float globalHeight = 1.2F;
        float globalDegree = 1.0F;

        float walkSpeed = 0.5f * globalSpeed;

        bob(this.headJoint, 0.125F * globalSpeed, 2 * globalHeight, false, ageInTicks, 0.5F, true);
        look(this.lookJoint, netHeadYaw, headPitch, 1.0f, 1.0f);

        swing(this.rootJoint, 0.01F * globalSpeed, 0.2f * globalDegree, false, 0.5F, 0.0F, ageInTicks, 0.5F, Axis.X);
        swing(this.ghoulBody, 0.01F * globalSpeed, 0.2f * globalDegree, false, 0.4F, 0.0F, ageInTicks, 0.5F, Axis.X);
        swing(this.headJoint, 0.01F * globalSpeed, 0.2f * globalDegree, false, 0.3F, 0.0F, ageInTicks, 0.5F, Axis.X);

        this.ghoulRightArm.rotateAngleX =+ (-(float)Math.PI / 2F) + (headPitch * ((float)Math.PI / 180F)) * 0.125F;
        this.ghoulRightArm.rotateAngleY =+ (netHeadYaw * ((float)Math.PI / 180F)) * 0.125F;

        this.ghoulLeftArm.rotateAngleX  =+ (-(float)Math.PI / 2F) + (headPitch * ((float)Math.PI / 180F)) * 0.125F;
        this.ghoulLeftArm.rotateAngleY  =+ (netHeadYaw * ((float)Math.PI / 180F)) * 0.125F;

        this.armsJoint.rotationPointY =+ entityIn.getArmHeight();
        this.ghoulHead.rotateAngleZ =+ entityIn.getHeadRotation();

        this.headJoint.cancelRotation(this.rootJoint, this.ghoulBody);
        this.armsJoint.cancelRotation(this.rootJoint, this.ghoulBody);
        this.legsJoint.cancelRotation(this.rootJoint, this.ghoulBody);

        this.ghoulDroop.cancelRotation(this.ghoulHead);
        this.ghoulDroop.rotateAngleX =- this.lookJoint.rotateAngleX;
    }

    public void setRGB(int red, int green, int blue) {
        this.red = MathUtils.mapRange(0, 255, 0, 1, red);
        this.green = MathUtils.mapRange(0, 255, 0, 1, green);
        this.blue = MathUtils.mapRange(0, 255, 0, 1, blue);
    }
}
