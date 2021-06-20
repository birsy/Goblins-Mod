package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.client.render.util.BirsyBaseModel;
import birsy.goblinsmod.client.render.util.BirsyModelRenderer;
import birsy.goblinsmod.common.entity.SchnozEntity;
import birsy.goblinsmod.core.util.MathUtils;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * SchnozModel - birse
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class SchnozModel<T extends SchnozEntity> extends BirsyBaseModel<T> {
    public BirsyModelRenderer rootJoint;
    public BirsyModelRenderer bodyJoint;
    public BirsyModelRenderer schnozHead;
    public BirsyModelRenderer legJoint;
    public BirsyModelRenderer schnozNose;
    public BirsyModelRenderer schnozButt;
    public BirsyModelRenderer schnozJaw;
    public BirsyModelRenderer earJoint;
    public BirsyModelRenderer schnozLeftNostril;
    public BirsyModelRenderer schnozRightNostril;
    public BirsyModelRenderer schnozRightEar;
    public BirsyModelRenderer schnozLeftEar;
    public BirsyModelRenderer schnozLeftThigh;
    public BirsyModelRenderer schnozRightThigh;
    public BirsyModelRenderer schnozLeftFoot;
    public BirsyModelRenderer schnozRightFoot;

    public SchnozModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.schnozHead = new BirsyModelRenderer(this, 0, 0);
        this.schnozHead.setRotationPoint(0.0F, -5.0F, -2.0F);
        this.schnozHead.addBox(-4.5F, -10.0F, -7.0F, 9.0F, 15.0F, 14.0F, 0.0F, 0.0F, 0.0F);
        this.rootJoint = new BirsyModelRenderer(this, 0, 0);
        this.rootJoint.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.rootJoint.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.schnozLeftFoot = new BirsyModelRenderer(this, 0, 49);
        this.schnozLeftFoot.setRotationPoint(0.49F, 4.0F, -1.0F);
        this.schnozLeftFoot.addBox(-2.5F, 0.0F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(schnozLeftFoot, -0.12217304763960307F, 0.0F, 0.0F);
        this.schnozNose = new BirsyModelRenderer(this, 32, 0);
        this.schnozNose.setRotationPoint(0.0F, -6.0F, -7.0F);
        this.schnozNose.addBox(-3.0F, 0.0F, 0.0F, 6.0F, 9.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(schnozNose, -0.45099308137849586F, 0.0F, 0.0F);
        this.earJoint = new BirsyModelRenderer(this, 0, 0);
        this.earJoint.setRotationPoint(0.0F, -2.5F, 3.0F);
        this.earJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(earJoint, 0.2617993877991494F, 0.0F, 0.0F);
        this.schnozRightNostril = new BirsyModelRenderer(this, 46, 14);
        this.schnozRightNostril.mirror = true;
        this.schnozRightNostril.setRotationPoint(-3.0F, 7.0F, 1.0F);
        this.schnozRightNostril.addBox(0.0F, -2.0F, 0.0F, 3.0F, 4.0F, 6.0F, 0.0F, 0.01F, 0.0F);
        this.setRotateAngle(schnozRightNostril, 0.0F, -0.6108652381980153F, 0.0F);
        this.schnozJaw = new BirsyModelRenderer(this, 0, 42);
        this.schnozJaw.setRotationPoint(0.0F, 5.0F, -3.0F);
        this.schnozJaw.addBox(-4.5F, 0.0F, -4.0F, 9.0F, 3.0F, 4.0F, 0.02F, 0.0F, 0.0F);
        this.setRotateAngle(schnozJaw, 0.21380283336930533F, 0.0F, 0.0F);
        this.schnozRightThigh = new BirsyModelRenderer(this, 22, 42);
        this.schnozRightThigh.mirror = true;
        this.schnozRightThigh.setRotationPoint(-3.5F, 0.0F, 0.0F);
        this.schnozRightThigh.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 8.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.legJoint = new BirsyModelRenderer(this, 0, 0);
        this.legJoint.setRotationPoint(0.0F, 1.0F, 0.75F);
        this.legJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(legJoint, 0.3490658503988659F, 0.0F, 0.0F);
        this.schnozButt = new BirsyModelRenderer(this, 0, 29);
        this.schnozButt.setRotationPoint(0.0F, 5.0F, -3.0F);
        this.schnozButt.addBox(-4.5F, 0.0F, 0.0F, 9.0F, 3.0F, 10.0F, -0.02F, 0.0F, 0.0F);
        this.setRotateAngle(schnozButt, 0.21380283336930533F, 0.0F, 0.0F);
        this.schnozLeftThigh = new BirsyModelRenderer(this, 22, 42);
        this.schnozLeftThigh.setRotationPoint(3.5F, 0.0F, 0.0F);
        this.schnozLeftThigh.addBox(-3.0F, -4.0F, -5.0F, 6.0F, 8.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.schnozRightEar = new BirsyModelRenderer(this, 0, 0);
        this.schnozRightEar.setRotationPoint(-4.5F, 0.0F, 0.0F);
        this.schnozRightEar.addBox(0.0F, -2.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(schnozRightEar, 0.0F, -0.5235987755982988F, 0.0F);
        this.bodyJoint = new BirsyModelRenderer(this, 0, 0);
        this.bodyJoint.setRotationPoint(0.0F, -9.0F, 2.0F);
        this.bodyJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(bodyJoint, -0.20943951023931953F, 0.0F, 0.0F);
        this.schnozRightFoot = new BirsyModelRenderer(this, 0, 49);
        this.schnozRightFoot.mirror = true;
        this.schnozRightFoot.setRotationPoint(-0.49F, 4.0F, -1.0F);
        this.schnozRightFoot.addBox(-2.5F, 0.0F, -3.0F, 5.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(schnozRightFoot, -0.12217304763960307F, 0.0F, 0.0F);
        this.schnozLeftEar = new BirsyModelRenderer(this, 0, 0);
        this.schnozLeftEar.mirror = true;
        this.schnozLeftEar.setRotationPoint(4.5F, 0.0F, 0.0F);
        this.schnozLeftEar.addBox(-1.0F, -2.0F, 0.0F, 1.0F, 4.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(schnozLeftEar, 0.0F, 0.5235987755982988F, 0.0F);
        this.schnozLeftNostril = new BirsyModelRenderer(this, 46, 14);
        this.schnozLeftNostril.setRotationPoint(3.0F, 7.0F, 1.0F);
        this.schnozLeftNostril.addBox(-3.0F, -2.0F, 0.0F, 3.0F, 4.0F, 6.0F, 0.0F, 0.01F, 0.0F);
        this.setRotateAngle(schnozLeftNostril, 0.0F, 0.6108652381980153F, 0.0F);
        this.bodyJoint.addChild(this.schnozHead);
        this.schnozLeftThigh.addChild(this.schnozLeftFoot);
        this.schnozHead.addChild(this.schnozNose);
        this.schnozHead.addChild(this.earJoint);
        this.schnozNose.addChild(this.schnozRightNostril);
        this.schnozHead.addChild(this.schnozJaw);
        this.legJoint.addChild(this.schnozRightThigh);
        this.bodyJoint.addChild(this.legJoint);
        this.schnozHead.addChild(this.schnozButt);
        this.legJoint.addChild(this.schnozLeftThigh);
        this.earJoint.addChild(this.schnozRightEar);
        this.rootJoint.addChild(this.bodyJoint);
        this.schnozRightThigh.addChild(this.schnozRightFoot);
        this.earJoint.addChild(this.schnozLeftEar);
        this.schnozNose.addChild(this.schnozLeftNostril);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.rootJoint).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
        float f = ageInTicks;
        float f1 = 0.5F;

        float globalSpeed = 1.0F;
        float globalHeight = 1.0F;
        float globalDegree = 1.0F;

        float walkSpeed = 0.5f * globalSpeed;

        resetParts(rootJoint, bodyJoint, schnozHead, legJoint, schnozNose, schnozButt, schnozJaw, earJoint, schnozLeftNostril, schnozRightNostril, schnozRightEar, schnozLeftEar, schnozLeftThigh, schnozRightThigh, schnozLeftFoot, schnozRightFoot);

        look(this.schnozHead, netHeadYaw, headPitch, 10.0F, 3.0F);

        //WALK
        bob(this.rootJoint, 2.0F * walkSpeed, 3 * globalHeight, true, f, f1, true);
        swing(this.rootJoint, walkSpeed, 0.1F * globalDegree, false, 0.0F, 0.0F, f, f1, Axis.Z);

        swingLimbs(this.schnozLeftThigh, this.schnozRightThigh, walkSpeed, globalDegree, 0.0F, 0.0F, f, f1);
        swingLimbs(this.schnozLeftFoot, this.schnozRightFoot, walkSpeed, globalDegree, 0.5F, 0.7F, f, f1);

        //IDLE
        swing(this.schnozJaw, 0.12F * globalSpeed, 0.1f * globalDegree, false, 1.5F, 0.1F, ageInTicks, 0.5F, Axis.X);

        look(this.schnozHead, netHeadYaw, headPitch, 10.0F, 3.0F);
    }
}
