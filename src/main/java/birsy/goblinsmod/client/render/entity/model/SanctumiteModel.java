package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.common.entity.SanctumiteEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SanctumiteModel<T extends SanctumiteEntity> extends BirsyBaseModel<T> {
    float transitionTicks;

    public BirsyModelRenderer sanctumiteHood;
    public BirsyModelRenderer sanctumiteHead;
    public BirsyModelRenderer sanctumiteLeftHood;
    public BirsyModelRenderer sanctumiteRightHood;
    public BirsyModelRenderer sanctumiteCape;
    public BirsyModelRenderer sanctumiteNeck;
    public BirsyModelRenderer sanctumiteCollar;
    public BirsyModelRenderer sanctumiteFrontCloth;
    public BirsyModelRenderer sanctumiteBackCloth;
    public BirsyModelRenderer sanctumiteCapeBottom;

    public SanctumiteModel() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.sanctumiteHead = new BirsyModelRenderer(this, 0, 0);
        this.sanctumiteHead.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.sanctumiteHead.addBox(-5.5F, -15.0F, -5.5F, 11.0F, 15.0F, 11.0F, -0.5F, -0.5F, -0.5F);
        this.sanctumiteBackCloth = new BirsyModelRenderer(this, 92, 26);
        this.sanctumiteBackCloth.setRotationPoint(0.0F, 5.1F, 3.0F);
        this.sanctumiteBackCloth.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 13.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(sanctumiteBackCloth, 0.0F, 3.141592653589793F, 0.0F);
        this.sanctumiteFrontCloth = new BirsyModelRenderer(this, 92, 26);
        this.sanctumiteFrontCloth.setRotationPoint(0.0F, 5.1F, -3.0F);
        this.sanctumiteFrontCloth.addBox(-3.0F, 0.0F, -0.5F, 6.0F, 13.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.sanctumiteCollar = new BirsyModelRenderer(this, 92, 0);
        this.sanctumiteCollar.setRotationPoint(0.0F, 7.0F, 0.0F);
        this.sanctumiteCollar.addBox(-4.0F, 0.0F, -4.0F, 8.0F, 5.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.sanctumiteRightHood = new BirsyModelRenderer(this, 44, 0);
        this.sanctumiteRightHood.mirror = true;
        this.sanctumiteRightHood.setRotationPoint(5.0F, 0.0F, 0.0F);
        this.sanctumiteRightHood.addBox(-0.5F, 0.0F, -5.5F, 1.0F, 21.0F, 11.0F, 0.0F, 0.0F, -0.01F);
        this.sanctumiteHood = new BirsyModelRenderer(this, 0, 26);
        this.sanctumiteHood.setRotationPoint(0.0F, 24.0F, 0.0F);
        this.sanctumiteHood.addBox(-5.5F, -15.0F, -5.5F, 11.0F, 15.0F, 11.0F, 0.0F, 0.0F, 0.0F);
        this.sanctumiteLeftHood = new BirsyModelRenderer(this, 44, 0);
        this.sanctumiteLeftHood.setRotationPoint(-5.0F, 0.0F, 0.0F);
        this.sanctumiteLeftHood.addBox(-0.5F, 0.0F, -5.5F, 1.0F, 21.0F, 11.0F, 0.0F, 0.0F, -0.01F);
        this.sanctumiteCape = new BirsyModelRenderer(this, 68, 0);
        this.sanctumiteCape.setRotationPoint(0.0F, 0.0F, 4.5F);
        this.sanctumiteCape.addBox(-5.5F, 0.0F, 0.0F, 11.0F, 21.0F, 1.0F, -0.05F, 0.0F, 0.0F);
        this.sanctumiteNeck = new BirsyModelRenderer(this, 92, 13);
        this.sanctumiteNeck.setRotationPoint(0.0F, -2.5F, 0.0F);
        this.sanctumiteNeck.addBox(-3.0F, 0.0F, -3.0F, 6.0F, 7.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.sanctumiteCapeBottom = new BirsyModelRenderer(this, 68, 22);
        this.sanctumiteCapeBottom.setRotationPoint(0.0F, 21.0F, 0.0F);
        this.sanctumiteCapeBottom.addBox(-5.5F, 0.0F, 0.0F, 11.0F, 18.0F, 1.0F, -0.05F, 0.0F, 0.0F);
        this.sanctumiteHood.addChild(this.sanctumiteHead);
        this.sanctumiteCollar.addChild(this.sanctumiteBackCloth);
        this.sanctumiteCollar.addChild(this.sanctumiteFrontCloth);
        this.sanctumiteNeck.addChild(this.sanctumiteCollar);
        this.sanctumiteHood.addChild(this.sanctumiteRightHood);
        this.sanctumiteHood.addChild(this.sanctumiteLeftHood);
        this.sanctumiteHood.addChild(this.sanctumiteCape);
        this.sanctumiteHead.addChild(this.sanctumiteNeck);
        this.sanctumiteCape.addChild(this.sanctumiteCapeBottom);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        this.sanctumiteHood.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha); //* transitionTicks);
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        resetParts(this.sanctumiteHood, this.sanctumiteHead, this.sanctumiteLeftHood, this.sanctumiteRightHood, this.sanctumiteCape, this.sanctumiteNeck, this.sanctumiteCollar, this.sanctumiteFrontCloth, this.sanctumiteBackCloth, this.sanctumiteCapeBottom);
        look(this.sanctumiteHood, netHeadYaw, headPitch, 1.0F, 1.0F);
        this.sanctumiteCape.rotateAngleX += -this.sanctumiteHood.rotateAngleX;
        this.sanctumiteLeftHood.rotateAngleX  += -this.sanctumiteHood.rotateAngleZ;
        this.sanctumiteRightHood.rotateAngleX += -this.sanctumiteHood.rotateAngleZ;


    }

    @Override
    public void setLivingAnimations(T entityIn, float limbSwing, float limbSwingAmount, float partialTicks) {

    }
}
