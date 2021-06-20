package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.client.render.util.BirsyBaseModel;
import birsy.goblinsmod.client.render.util.BirsyModelRenderer;
import birsy.goblinsmod.common.entity.boss.king_boss.CorruptedKingEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CursedKingModel - birse
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class CorruptedKingModel<T extends CorruptedKingEntity> extends BirsyBaseModel<T> {
    public BirsyModelRenderer rootJoint;
    public BirsyModelRenderer swordJoint;
    public BirsyModelRenderer kingWaist;
    public BirsyModelRenderer kingTorso;
    public BirsyModelRenderer kingBackJacketFlap;
    public BirsyModelRenderer kingFrontRightJacketFlap;
    public BirsyModelRenderer kingFrontLeftJacketFlap;
    public BirsyModelRenderer legJoint;
    public BirsyModelRenderer kingHead;
    public BirsyModelRenderer kingCloak;
    public BirsyModelRenderer armJoint;
    public BirsyModelRenderer kingCrown;
    public BirsyModelRenderer kingNose;
    public BirsyModelRenderer kingJaw;
    public BirsyModelRenderer kingRightEar;
    public BirsyModelRenderer kingLeftEar;
    public BirsyModelRenderer kingCloakFront;
    public BirsyModelRenderer kingCloakBack;
    public BirsyModelRenderer rightArmJoint;
    public BirsyModelRenderer leftArmJoint;
    public BirsyModelRenderer kingRightArm;
    public BirsyModelRenderer kingCrossedRightArm;
    public BirsyModelRenderer kingRightPauldron;
    public BirsyModelRenderer rightSwordJoint;
    public BirsyModelRenderer kingCrossedRightForearm;
    public BirsyModelRenderer rightCrossedSwordJoint;
    public BirsyModelRenderer swordHandle;
    public BirsyModelRenderer swordGuard;
    public BirsyModelRenderer swordHilt;
    public BirsyModelRenderer swordBlade;
    public BirsyModelRenderer swordBladeTip;
    public BirsyModelRenderer kingRightPauldronTopRim;
    public BirsyModelRenderer kingRightPauldronBottomRim;
    public BirsyModelRenderer kingLeftArm;
    public BirsyModelRenderer kingCrossedLeftArm;
    public BirsyModelRenderer kingLeftPauldron;
    public BirsyModelRenderer leftSwordJoint;
    public BirsyModelRenderer kingCrossedLeftForearm;
    public BirsyModelRenderer leftCrossedSwordJoint;
    public BirsyModelRenderer kingLeftPauldronTopRim;
    public BirsyModelRenderer kingLeftPauldronBottomRim;
    public BirsyModelRenderer kingRightLeg;
    public BirsyModelRenderer kingLeftLeg;

    private boolean rightArmPose;
    private boolean leftArmPose;

    public CorruptedKingModel() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.kingCrown = new BirsyModelRenderer(this, 0, 58);
        this.kingCrown.setRotationPoint(0.0F, -30.0F, 0.0F);
        this.kingCrown.addBox(-4.5F, -14.0F, -4.5F, 9.0F, 14.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.rightArmJoint = new BirsyModelRenderer(this, 0, 0);
        this.rightArmJoint.setRotationPoint(-14.0F, 0.0F, 0.0F);
        this.rightArmJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightArmJoint, -0.7853981633974483F, 0.0F, 0.0F);
        this.kingCrossedRightForearm = new BirsyModelRenderer(this, 110, 68);
        this.kingCrossedRightForearm.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.kingCrossedRightForearm.addBox(0.0F, -3.0F, -3.0F, 14.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.kingWaist = new BirsyModelRenderer(this, 180, 29);
        this.kingWaist.setRotationPoint(0.0F, -26.0F, 0.0F);
        this.kingWaist.addBox(-11.0F, -5.0F, -7.0F, 22.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.kingRightPauldronBottomRim = new BirsyModelRenderer(this, 152, 41);
        this.kingRightPauldronBottomRim.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingRightPauldronBottomRim.addBox(-8.0F, -1.0F, -4.5F, 9.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.kingRightPauldron = new BirsyModelRenderer(this, 144, 58);
        this.kingRightPauldron.setRotationPoint(-0.5F, 0.0F, 0.25F);
        this.kingRightPauldron.addBox(-6.0F, -5.0F, -3.5F, 7.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(kingRightPauldron, 0.0F, 0.0F, -0.2617993877991494F);
        this.swordJoint = new BirsyModelRenderer(this, 0, 0);
        this.swordJoint.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.swordJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.kingHead = new BirsyModelRenderer(this, 0, 0);
        this.kingHead.setRotationPoint(0.0F, -27.0F, -3.0F);
        this.kingHead.addBox(-11.0F, -28.0F, -9.5F, 22.0F, 30.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.rightSwordJoint = new BirsyModelRenderer(this, 0, 0);
        this.rightSwordJoint.setRotationPoint(-2.5F, 29.5F, 0.0F);
        this.rightSwordJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.swordBlade = new BirsyModelRenderer(this, 82, 2);
        this.swordBlade.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.swordBlade.addBox(-3.5F, -34.0F, -0.5F, 7.0F, 34.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.kingCloakFront = new BirsyModelRenderer(this, 88, 90);
        this.kingCloakFront.setRotationPoint(0.0F, 0.5F, -0.25F);
        this.kingCloakFront.addBox(-14.0F, 0.0F, -8.0F, 28.0F, 30.0F, 8.0F, 0.49F, 0.0F, 0.25F);
        this.leftArmJoint = new BirsyModelRenderer(this, 0, 0);
        this.leftArmJoint.setRotationPoint(14.0F, 0.0F, 0.0F);
        this.leftArmJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftArmJoint, -0.7853981633974483F, 0.0F, 0.0F);
        this.kingLeftArm = new BirsyModelRenderer(this, 88, 47);
        this.kingLeftArm.mirror = true;
        this.kingLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingLeftArm.addBox(0.0F, -3.0F, -3.0F, 5.0F, 35.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.kingCrossedLeftArm = new BirsyModelRenderer(this, 110, 41);
        this.kingCrossedLeftArm.mirror = true;
        this.kingCrossedLeftArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingCrossedLeftArm.addBox(0.0F, -3.0F, -3.0F, 5.0F, 21.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.kingLeftLeg = new BirsyModelRenderer(this, 64, 49);
        this.kingLeftLeg.mirror = true;
        this.kingLeftLeg.setRotationPoint(7.0F, 0.0F, 0.0F);
        this.kingLeftLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 24.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.kingCloakBack = new BirsyModelRenderer(this, 160, 90);
        this.kingCloakBack.setRotationPoint(0.0F, 0.5F, 0.25F);
        this.kingCloakBack.addBox(-14.0F, 0.0F, 0.0F, 28.0F, 30.0F, 8.0F, 0.51F, 0.0F, 0.25F);
        this.swordBladeTip = new BirsyModelRenderer(this, 82, 0);
        this.swordBladeTip.setRotationPoint(0.0F, -34.0F, 0.0F);
        this.swordBladeTip.addBox(-1.5F, -1.0F, -0.5F, 3.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.legJoint = new BirsyModelRenderer(this, 0, 0);
        this.legJoint.setRotationPoint(0.0F, 2.0F, 0.0F);
        this.legJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.kingLeftPauldron = new BirsyModelRenderer(this, 144, 58);
        this.kingLeftPauldron.mirror = true;
        this.kingLeftPauldron.setRotationPoint(0.5F, 0.0F, 0.25F);
        this.kingLeftPauldron.addBox(-1.0F, -5.0F, -3.5F, 7.0F, 6.0F, 7.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(kingLeftPauldron, 0.0F, 0.0F, 0.2617993877991494F);
        this.leftSwordJoint = new BirsyModelRenderer(this, 0, 0);
        this.leftSwordJoint.setRotationPoint(2.5F, 29.5F, 0.0F);
        this.leftSwordJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.kingLeftEar = new BirsyModelRenderer(this, 63, 0);
        this.kingLeftEar.mirror = true;
        this.kingLeftEar.setRotationPoint(11.0F, -17.0F, 0.0F);
        this.kingLeftEar.addBox(0.0F, -5.5F, 0.0F, 5.0F, 11.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(kingLeftEar, 0.0F, -0.7853981633974483F, 0.0F);
        this.swordGuard = new BirsyModelRenderer(this, 82, 37);
        this.swordGuard.setRotationPoint(0.0F, -3.5F, 0.0F);
        this.swordGuard.addBox(-5.0F, -1.0F, -1.0F, 10.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.5F);
        this.armJoint = new BirsyModelRenderer(this, 0, 0);
        this.armJoint.setRotationPoint(0.0F, -20.0F, 0.0F);
        this.armJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.kingCrossedRightArm = new BirsyModelRenderer(this, 110, 41);
        this.kingCrossedRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingCrossedRightArm.addBox(-5.0F, -3.0F, -3.0F, 5.0F, 21.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.kingRightEar = new BirsyModelRenderer(this, 63, 0);
        this.kingRightEar.setRotationPoint(-11.0F, -17.0F, 0.0F);
        this.kingRightEar.addBox(-5.0F, -5.5F, 0.0F, 5.0F, 11.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(kingRightEar, 0.0F, 0.7853981633974483F, 0.0F);
        this.swordHandle = new BirsyModelRenderer(this, 82, 41);
        this.swordHandle.setRotationPoint(2.5F, 7.0F, 0.0F);
        this.swordHandle.addBox(-1.0F, -2.5F, -1.0F, 2.0F, 5.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(swordHandle, -2.356194490192345F, 0.0F, 0.0F);
        this.kingFrontRightJacketFlap = new BirsyModelRenderer(this, 194, 0);
        this.kingFrontRightJacketFlap.setRotationPoint(-11.0F, 2.0F, -4.0F);
        this.kingFrontRightJacketFlap.addBox(0.0F, 0.0F, -3.0F, 14.0F, 10.0F, 3.0F, -0.01F, 0.0F, 0.0F);
        this.kingCrossedLeftForearm = new BirsyModelRenderer(this, 110, 68);
        this.kingCrossedLeftForearm.mirror = true;
        this.kingCrossedLeftForearm.setRotationPoint(0.0F, 15.0F, 0.0F);
        this.kingCrossedLeftForearm.addBox(-14.0F, -3.0F, -3.0F, 14.0F, 6.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.leftCrossedSwordJoint = new BirsyModelRenderer(this, 0, 0);
        this.leftCrossedSwordJoint.setRotationPoint(-11.5F, 0.0F, 0.0F);
        this.leftCrossedSwordJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.kingLeftPauldronTopRim = new BirsyModelRenderer(this, 132, 41);
        this.kingLeftPauldronTopRim.mirror = true;
        this.kingLeftPauldronTopRim.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingLeftPauldronTopRim.addBox(-1.0F, -6.0F, -4.5F, 1.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.rootJoint = new BirsyModelRenderer(this, 0, 0);
        this.rootJoint.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.rootJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.kingCloak = new BirsyModelRenderer(this, 0, 87);
        this.kingCloak.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingCloak.addBox(-14.0F, -25.0F, -8.0F, 28.0F, 25.0F, 16.0F, 0.5F, 0.5F, 0.5F);
        this.kingRightArm = new BirsyModelRenderer(this, 88, 47);
        this.kingRightArm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingRightArm.addBox(-5.0F, -3.0F, -3.0F, 5.0F, 35.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.kingRightPauldronTopRim = new BirsyModelRenderer(this, 132, 41);
        this.kingRightPauldronTopRim.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingRightPauldronTopRim.addBox(-0.0F, -6.0F, -4.5F, 1.0F, 5.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.swordHilt = new BirsyModelRenderer(this, 90, 41);
        this.swordHilt.setRotationPoint(0.0F, 4.0F, 0.0F);
        this.swordHilt.addBox(-1.5F, -1.5F, -1.5F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(swordHilt, 0.0F, 0.0F, -0.7853981633974483F);
        this.kingBackJacketFlap = new BirsyModelRenderer(this, 194, 13);
        this.kingBackJacketFlap.setRotationPoint(0.0F, 2.0F, 4.0F);
        this.kingBackJacketFlap.addBox(-11.0F, 0.0F, 0.0F, 22.0F, 13.0F, 3.0F, -0.01F, 0.0F, 0.0F);
        this.kingTorso = new BirsyModelRenderer(this, 106, 0);
        this.kingTorso.setRotationPoint(0.0F, -5.0F, 0.0F);
        this.kingTorso.addBox(-14.0F, -25.0F, -8.0F, 28.0F, 25.0F, 16.0F, 0.0F, 0.0F, 0.0F);
        this.kingLeftPauldronBottomRim = new BirsyModelRenderer(this, 152, 41);
        this.kingLeftPauldronBottomRim.mirror = true;
        this.kingLeftPauldronBottomRim.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.kingLeftPauldronBottomRim.addBox(-1.0F, -1.0F, -4.5F, 9.0F, 3.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.kingNose = new BirsyModelRenderer(this, 0, 0);
        this.kingNose.setRotationPoint(0.0F, -21.0F, -9.5F);
        this.kingNose.addBox(-2.0F, -2.0F, -4.0F, 4.0F, 12.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(kingNose, -0.0781907508222411F, 0.0F, 0.0F);
        this.rightCrossedSwordJoint = new BirsyModelRenderer(this, 0, 0);
        this.rightCrossedSwordJoint.setRotationPoint(11.5F, 0.0F, 0.0F);
        this.rightCrossedSwordJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.kingFrontLeftJacketFlap = new BirsyModelRenderer(this, 228, 0);
        this.kingFrontLeftJacketFlap.setRotationPoint(11.0F, 2.0F, -4.0F);
        this.kingFrontLeftJacketFlap.addBox(-8.0F, 0.0F, -3.0F, 8.0F, 10.0F, 3.0F, -0.01F, 0.0F, 0.0F);
        this.kingRightLeg = new BirsyModelRenderer(this, 64, 49);
        this.kingRightLeg.setRotationPoint(-7.0F, 0.0F, 0.0F);
        this.kingRightLeg.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 24.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.kingJaw = new BirsyModelRenderer(this, 0, 49);
        this.kingJaw.setRotationPoint(0.0F, -1.0F, -6.5F);
        this.kingJaw.addBox(-10.0F, -2.0F, -4.0F, 20.0F, 5.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(kingJaw, 0.17453292519943295F, 0.0F, 0.0F);
        this.kingHead.addChild(this.kingCrown);
        this.armJoint.addChild(this.rightArmJoint);
        this.kingCrossedRightArm.addChild(this.kingCrossedRightForearm);
        this.rootJoint.addChild(this.kingWaist);
        this.kingRightPauldron.addChild(this.kingRightPauldronBottomRim);
        this.rightArmJoint.addChild(this.kingRightPauldron);
        this.kingTorso.addChild(this.kingHead);
        this.kingRightArm.addChild(this.rightSwordJoint);
        this.swordGuard.addChild(this.swordBlade);
        this.kingCloak.addChild(this.kingCloakFront);
        this.armJoint.addChild(this.leftArmJoint);
        this.leftArmJoint.addChild(this.kingLeftArm);
        this.leftArmJoint.addChild(this.kingCrossedLeftArm);
        this.legJoint.addChild(this.kingLeftLeg);
        this.kingCloak.addChild(this.kingCloakBack);
        this.swordBlade.addChild(this.swordBladeTip);
        this.kingWaist.addChild(this.legJoint);
        this.leftArmJoint.addChild(this.kingLeftPauldron);
        this.kingLeftArm.addChild(this.leftSwordJoint);
        this.kingHead.addChild(this.kingLeftEar);
        this.swordHandle.addChild(this.swordGuard);
        this.kingTorso.addChild(this.armJoint);
        this.rightArmJoint.addChild(this.kingCrossedRightArm);
        this.kingHead.addChild(this.kingRightEar);
        this.rightCrossedSwordJoint.addChild(this.swordHandle);
        this.kingWaist.addChild(this.kingFrontRightJacketFlap);
        this.kingCrossedLeftArm.addChild(this.kingCrossedLeftForearm);
        this.kingCrossedLeftForearm.addChild(this.leftCrossedSwordJoint);
        this.kingLeftPauldron.addChild(this.kingLeftPauldronTopRim);
        this.kingTorso.addChild(this.kingCloak);
        this.rightArmJoint.addChild(this.kingRightArm);
        this.kingRightPauldron.addChild(this.kingRightPauldronTopRim);
        this.swordHandle.addChild(this.swordHilt);
        this.kingWaist.addChild(this.kingBackJacketFlap);
        this.kingWaist.addChild(this.kingTorso);
        this.kingLeftPauldron.addChild(this.kingLeftPauldronBottomRim);
        this.kingHead.addChild(this.kingNose);
        this.kingCrossedRightForearm.addChild(this.rightCrossedSwordJoint);
        this.kingWaist.addChild(this.kingFrontLeftJacketFlap);
        this.legJoint.addChild(this.kingRightLeg);
        this.kingHead.addChild(this.kingJaw);

        this.rightArmPose = true;
        this.leftArmPose = true;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.swordJoint, this.rootJoint).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch)
    {
        resetParts(this.rootJoint, this.swordJoint, this.kingWaist, this.kingTorso, this.kingBackJacketFlap, this.kingFrontRightJacketFlap, this.kingFrontLeftJacketFlap, this.legJoint, this.kingHead, this.kingCloak, this.armJoint, this.kingCrown, this.kingNose, this.kingJaw, this.kingRightEar, this.kingLeftEar, this.kingCloakFront, this.kingCloakBack, this.rightArmJoint, this.leftArmJoint, this.kingRightArm, this.kingCrossedRightArm, this.kingRightPauldron, this.rightSwordJoint, this.kingCrossedRightForearm, this.rightCrossedSwordJoint, this.swordHandle, this.swordGuard, this.swordHilt, this.swordBlade, this.swordBladeTip, this.kingRightPauldronTopRim, this.kingRightPauldronBottomRim, this.kingLeftArm, this.kingCrossedLeftArm, this.kingLeftPauldron, this.leftSwordJoint, this.kingCrossedLeftForearm, this.leftCrossedSwordJoint, this.kingLeftPauldronTopRim, this.kingLeftPauldronBottomRim, this.kingRightLeg, this.kingLeftLeg);

        float f = ageInTicks;
        float f1 = 0.5F;

        float globalSpeed = 0.25F;
        float globalHeight = 1.0F;
        float globalDegree = 1.0F;

        float walkSpeed = 0.5f * globalSpeed;

        /**
         * Idle Animations
         */

        /**
         * Walk Animations
         */
        //TODO walk animations!


        /**
         * Attack Animations
         */
        //TODO attack animations!


        /**
         * Model groundwork - the jacket flaps are affected by gravity, the arms can't exist at the same time, etc.
         */
        this.kingBackJacketFlap.rotateAngleX =+ MathHelper.clamp(-(this.kingWaist.rotateAngleX + this.rootJoint.rotateAngleX), 0, Float.POSITIVE_INFINITY);
        this.kingFrontLeftJacketFlap.rotateAngleX  =+ MathHelper.clamp(this.kingWaist.rotateAngleX + this.rootJoint.rotateAngleX, 0, Float.POSITIVE_INFINITY);
        this.kingFrontRightJacketFlap.rotateAngleX =+ MathHelper.clamp(this.kingWaist.rotateAngleX + this.rootJoint.rotateAngleX, 0, Float.POSITIVE_INFINITY);

        this.kingCloakBack.rotateAngleX   =+ MathHelper.clamp(-(this.kingWaist.rotateAngleX + this.rootJoint.rotateAngleX + this.kingCloak.rotateAngleX + this.kingTorso.rotateAngleX), 0, Float.POSITIVE_INFINITY);
        this.kingCloakFront.rotateAngleX  =+ MathHelper.clamp( (this.kingWaist.rotateAngleX + this.rootJoint.rotateAngleX + this.kingCloak.rotateAngleX + this.kingTorso.rotateAngleX), 0, Float.POSITIVE_INFINITY);

        if (rightArmPose) {
            this.kingRightArm.showModel = false;
            this.kingCrossedRightArm.showModel = true;
        } else {
            this.kingRightArm.showModel = true;
            this.kingCrossedRightArm.showModel = false;
        }

        if (leftArmPose) {
            this.kingLeftArm.showModel = false;
            this.kingCrossedLeftArm.showModel = true;
        } else {
            this.kingLeftArm.showModel = true;
            this.kingCrossedLeftArm.showModel = false;
        }
    }
}
