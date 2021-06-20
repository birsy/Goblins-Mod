package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.client.render.util.BirsyBaseModel;
import birsy.goblinsmod.client.render.util.BirsyModelRenderer;
import birsy.goblinsmod.common.entity.CobuntoEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CobuntoModel - birse
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CobuntoModel<T extends CobuntoEntity> extends BirsyBaseModel<T> {
    public BirsyModelRenderer rootPart;
    public BirsyModelRenderer cobuntoBody;
    public BirsyModelRenderer cobuntoCloak;
    public BirsyModelRenderer cobuntoHead;
    public BirsyModelRenderer cobuntoRightLeg;
    public BirsyModelRenderer cobuntoLeftLeg;
    public BirsyModelRenderer cobuntoRightArm;
    public BirsyModelRenderer cobuntoLeftArm;
    public BirsyModelRenderer cobuntoBack;
    public BirsyModelRenderer cobuntoFrontRightFringe;
    public BirsyModelRenderer cobuntoFrontLeftFringe;
    public BirsyModelRenderer cobuntoBackRightFringe;
    public BirsyModelRenderer cobuntoBackLeftFringe;
    public BirsyModelRenderer cobuntoBandana;
    public BirsyModelRenderer cobuntoHood;
    public BirsyModelRenderer cobuntoRightEar;
    public BirsyModelRenderer cobuntoLeftEar;
    public BirsyModelRenderer cobuntoNose;

    public CobuntoModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.cobuntoHood = new BirsyModelRenderer(this, 0, 81);
        this.cobuntoHood.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cobuntoHood.addBox(-5.0F, -8.0F, -7.0F, 10.0F, 17.0F, 9.0F, 0.5F, 0.5F, 0.5F);
        this.cobuntoBack = new BirsyModelRenderer(this, 120, 0);
        this.cobuntoBack.setRotationPoint(0.0F, -25.5F, 0.0F);
        this.cobuntoBack.addBox(-16.0F, -3.5F, -9.0F, 32.0F, 3.0F, 18.0F, 0.5F, 0.5F, 0.5F);
        this.cobuntoBackRightFringe = new BirsyModelRenderer(this, 120, 89);
        this.cobuntoBackRightFringe.setRotationPoint(-20.5F, 5.5F, 0.0F);
        this.cobuntoBackRightFringe.addBox(0.26F, 0.25F, 0.25F, 20.0F, 8.0F, 10.0F, 0.25F, 0.25F, 0.25F);
        this.cobuntoRightLeg = new BirsyModelRenderer(this, 24, 50);
        this.cobuntoRightLeg.setRotationPoint(-12.0F, 5.0F, 0.0F);
        this.cobuntoRightLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 18.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.cobuntoRightArm = new BirsyModelRenderer(this, 0, 50);
        this.cobuntoRightArm.setRotationPoint(-20.0F, -9.0F, -6.0F);
        this.cobuntoRightArm.addBox(-3.0F, -1.5F, -1.5F, 3.0F, 28.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.cobuntoHead = new BirsyModelRenderer(this, 56, 50);
        this.cobuntoHead.setRotationPoint(0.0F, -27.0F, -10.0F);
        this.cobuntoHead.addBox(-5.0F, -8.0F, -7.0F, 10.0F, 10.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.cobuntoBandana = new BirsyModelRenderer(this, 56, 69);
        this.cobuntoBandana.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.cobuntoBandana.addBox(-5.0F, 0.0F, -7.0F, 10.0F, 7.0F, 9.0F, 0.3F, 0.0F, 0.3F);
        this.cobuntoRightEar = new BirsyModelRenderer(this, 94, 50);
        this.cobuntoRightEar.setRotationPoint(-5.0F, -1.0F, -4.0F);
        this.cobuntoRightEar.addBox(-4.0F, -2.5F, 0.0F, 4.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(cobuntoRightEar, 0.0F, 0.3490658503988659F, 0.0F);
        this.rootPart = new BirsyModelRenderer(this, 0, 0);
        this.rootPart.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.rootPart.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.cobuntoCloak = new BirsyModelRenderer(this, 120, 21);
        this.cobuntoCloak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.cobuntoCloak.addBox(-20.0F, -25.0F, -10.0F, 40.0F, 30.0F, 20.0F, 0.5F, 0.5F, 0.5F);
        this.cobuntoNose = new BirsyModelRenderer(this, 94, 56);
        this.cobuntoNose.setRotationPoint(0.0F, -6.0F, -7.0F);
        this.cobuntoNose.addBox(-2.0F, 0.0F, 0.0F, 4.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(cobuntoNose, -0.5235987755982988F, 0.0F, 0.0F);
        this.cobuntoLeftLeg = new BirsyModelRenderer(this, 40, 50);
        this.cobuntoLeftLeg.setRotationPoint(12.0F, 5.0F, 0.0F);
        this.cobuntoLeftLeg.addBox(-2.0F, 0.0F, -2.0F, 4.0F, 18.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.cobuntoFrontRightFringe = new BirsyModelRenderer(this, 120, 71);
        this.cobuntoFrontRightFringe.setRotationPoint(-20.5F, 5.5F, 0.0F);
        this.cobuntoFrontRightFringe.addBox(0.26F, 0.25F, -10.25F, 20.0F, 8.0F, 10.0F, 0.25F, 0.25F, 0.25F);
        this.cobuntoLeftArm = new BirsyModelRenderer(this, 12, 50);
        this.cobuntoLeftArm.setRotationPoint(20.0F, -9.0F, -6.0F);
        this.cobuntoLeftArm.addBox(0.0F, -1.5F, -1.5F, 3.0F, 28.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.cobuntoLeftEar = new BirsyModelRenderer(this, 94, 50);
        this.cobuntoLeftEar.mirror = true;
        this.cobuntoLeftEar.setRotationPoint(5.0F, -1.0F, -4.0F);
        this.cobuntoLeftEar.addBox(0.0F, -2.5F, 0.0F, 4.0F, 5.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(cobuntoLeftEar, 0.0F, -0.3490658503988659F, 0.0F);
        this.cobuntoBody = new BirsyModelRenderer(this, 0, 0);
        this.cobuntoBody.setRotationPoint(0.0F, -23.0F, 0.0F);
        this.cobuntoBody.addBox(-20.0F, -25.0F, -10.0F, 40.0F, 30.0F, 20.0F, 0.0F, 0.0F, 0.0F);
        this.cobuntoBackLeftFringe = new BirsyModelRenderer(this, 180, 89);
        this.cobuntoBackLeftFringe.setRotationPoint(20.5F, 5.5F, 0.0F);
        this.cobuntoBackLeftFringe.addBox(-20.26F, 0.25F, 0.25F, 20.0F, 8.0F, 10.0F, 0.25F, 0.25F, 0.25F);
        this.cobuntoFrontLeftFringe = new BirsyModelRenderer(this, 180, 71);
        this.cobuntoFrontLeftFringe.setRotationPoint(20.5F, 5.5F, 0.0F);
        this.cobuntoFrontLeftFringe.addBox(-20.26F, 0.25F, -10.25F, 20.0F, 8.0F, 10.0F, 0.25F, 0.25F, 0.25F);
        this.cobuntoHead.addChild(this.cobuntoHood);
        this.cobuntoCloak.addChild(this.cobuntoBack);
        this.cobuntoCloak.addChild(this.cobuntoBackRightFringe);
        this.cobuntoBody.addChild(this.cobuntoRightLeg);
        this.cobuntoBody.addChild(this.cobuntoRightArm);
        this.cobuntoBody.addChild(this.cobuntoHead);
        this.cobuntoHead.addChild(this.cobuntoBandana);
        this.cobuntoHead.addChild(this.cobuntoRightEar);
        this.cobuntoBody.addChild(this.cobuntoCloak);
        this.cobuntoHead.addChild(this.cobuntoNose);
        this.cobuntoBody.addChild(this.cobuntoLeftLeg);
        this.cobuntoCloak.addChild(this.cobuntoFrontRightFringe);
        this.cobuntoBody.addChild(this.cobuntoLeftArm);
        this.cobuntoHead.addChild(this.cobuntoLeftEar);
        this.rootPart.addChild(this.cobuntoBody);
        this.cobuntoCloak.addChild(this.cobuntoBackLeftFringe);
        this.cobuntoCloak.addChild(this.cobuntoFrontLeftFringe);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.rootPart).forEach((BirsyModelRenderer) -> { 
            BirsyModelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float f = ageInTicks;
        float f1 = 0.5F;

        float globalSpeed = 0.25F;
        float globalHeight = 1.0F;
        float globalDegree = 1.0F;

        float walkSpeed = 0.5f * globalSpeed;

        resetParts(this.rootPart, this.cobuntoBody, this.cobuntoCloak, this.cobuntoHead, this.cobuntoRightLeg, this.cobuntoLeftLeg, this.cobuntoRightArm, this.cobuntoLeftArm, this.cobuntoBack, this.cobuntoFrontRightFringe, this.cobuntoFrontLeftFringe, this.cobuntoBackRightFringe, this.cobuntoBackLeftFringe, this.cobuntoBandana, this.cobuntoHood, this.cobuntoRightEar, this.cobuntoLeftEar, this.cobuntoNose);

        //WALK
        bob(this.cobuntoBody, 2.0F * walkSpeed, 3 * globalHeight, true, f, f1, true);
        bob(this.cobuntoHead, 2.0F * walkSpeed, globalHeight, false, f, f1, true);

        swing(this.cobuntoBody, walkSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Z);

        swingLimbs(this.cobuntoLeftLeg, this.cobuntoRightLeg, walkSpeed, globalDegree, 0.0F, 0.0F, f, f1);
        cobuntoFrontLeftFringe.rotateAngleX  =+ Math.min(this.calculateRotation(walkSpeed, 0.5F * globalDegree, true,  0.0F, 0.0F, f, f1), 0.0F);
        cobuntoFrontRightFringe.rotateAngleX =+ Math.min(this.calculateRotation(walkSpeed, 0.5F * globalDegree, false, 0.0F, 0.0F, f, f1), 0.0F);
        cobuntoBackLeftFringe.rotateAngleX   =+ Math.max(this.calculateRotation(walkSpeed, 0.5F * globalDegree, true,  0.0F, 0.0F, f, f1), 0.0F);
        cobuntoBackRightFringe.rotateAngleX  =+ Math.max(this.calculateRotation(walkSpeed, 0.5F * globalDegree, false, 0.0F, 0.0F, f, f1), 0.0F);

        swingLimbs(this.cobuntoRightArm, this.cobuntoLeftArm, walkSpeed, 0.5F * globalDegree, 0.0F, 0.0F, f, f1);
        bob(this.cobuntoRightArm, 2.0F * walkSpeed, globalHeight, false, f, f1, true);
        bob(this.cobuntoLeftArm, 2.0F * walkSpeed, globalHeight, false, f, f1, true);
    }

}
