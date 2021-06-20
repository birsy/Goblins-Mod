package birsy.goblinsmod.client.render.entity.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * WitherModel - birse
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class WitherModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer rootJoint;
    public ModelRenderer witherSpine;
    public ModelRenderer witherShoulders;
    public ModelRenderer witherTailbone;
    public ModelRenderer ribsJoint;
    public ModelRenderer witherRightHead;
    public ModelRenderer witherLeftHead;
    public ModelRenderer witherCenterHead;
    public ModelRenderer witherRib1;
    public ModelRenderer witherRib2;
    public ModelRenderer witherRib3;
    public ModelRenderer witherRib4;
    public ModelRenderer witherRib5;
    public ModelRenderer witherSternum;

    public WitherModel() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.rootJoint = new ModelRenderer(this, 0, 0);
        this.rootJoint.setRotationPoint(0.0F, 10.0F, 0.0F);
        this.rootJoint.addBox(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.witherTailbone = new ModelRenderer(this, 56, 20);
        this.witherTailbone.setRotationPoint(0.0F, 8.0F, 0.0F);
        this.witherTailbone.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, 0.25F, 0.25F, 0.25F);
        this.setRotateAngle(witherTailbone, 0.3127630032889644F, 0.0F, 0.0F);
        this.witherRib5 = new ModelRenderer(this, 44, 47);
        this.witherRib5.setRotationPoint(0.0F, 7.0F, 0.5F);
        this.witherRib5.addBox(-3.0F, -0.5F, -3.5F, 6.0F, 1.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(witherRib5, 0.2617993877991494F, 0.0F, 0.0F);
        this.witherRib3 = new ModelRenderer(this, 0, 47);
        this.witherRib3.setRotationPoint(0.0F, 0.5F, -1.0F);
        this.witherRib3.addBox(-7.0F, -1.0F, -7.0F, 14.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(witherRib3, 0.08726646259971647F, 0.0F, 0.0F);
        this.witherShoulders = new ModelRenderer(this, 0, 40);
        this.witherShoulders.setRotationPoint(0.0F, -8.0F, 0.0F);
        this.witherShoulders.addBox(-14.0F, -3.0F, -2.0F, 28.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.witherRightHead = new ModelRenderer(this, 0, 24);
        this.witherRightHead.mirror = true;
        this.witherRightHead.setRotationPoint(-12.0F, -2.0F, 0.0F);
        this.witherRightHead.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.witherRib1 = new ModelRenderer(this, 0, 47);
        this.witherRib1.setRotationPoint(0.0F, -7.0F, -1.0F);
        this.witherRib1.addBox(-7.0F, -1.0F, -7.0F, 14.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(witherRib1, -0.08726646259971647F, 0.0F, 0.0F);
        this.witherSternum = new ModelRenderer(this, 44, 52);
        this.witherSternum.setRotationPoint(0.0F, 0.0F, -6.5F);
        this.witherSternum.addBox(-1.5F, -4.5F, -1.5F, 3.0F, 9.0F, 3.0F, 0.0F, 0.05F, 0.0F);
        this.ribsJoint = new ModelRenderer(this, 0, 0);
        this.ribsJoint.setRotationPoint(0.0F, -1.0F, 0.25F);
        this.ribsJoint.addBox(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.witherRib4 = new ModelRenderer(this, 0, 57);
        this.witherRib4.setRotationPoint(0.0F, 4.0F, -0.5F);
        this.witherRib4.addBox(-5.0F, -1.0F, -4.0F, 10.0F, 2.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(witherRib4, 0.1308996938995747F, 0.0F, 0.0F);
        this.witherLeftHead = new ModelRenderer(this, 0, 24);
        this.witherLeftHead.setRotationPoint(12.0F, -2.0F, 0.0F);
        this.witherLeftHead.addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.witherSpine = new ModelRenderer(this, 48, 0);
        this.witherSpine.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.witherSpine.addBox(-2.0F, -8.0F, -2.0F, 4.0F, 16.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.witherRib2 = new ModelRenderer(this, 0, 47);
        this.witherRib2.mirror = true;
        this.witherRib2.setRotationPoint(0.0F, -3.5F, -1.5F);
        this.witherRib2.addBox(-7.0F, -1.0F, -7.0F, 14.0F, 2.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.witherCenterHead = new ModelRenderer(this, 0, 0);
        this.witherCenterHead.setRotationPoint(0.0F, -2.5F, -2.0F);
        this.witherCenterHead.addBox(-6.0F, -12.0F, -6.0F, 12.0F, 12.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.witherSpine.addChild(this.witherTailbone);
        this.ribsJoint.addChild(this.witherRib5);
        this.ribsJoint.addChild(this.witherRib3);
        this.witherSpine.addChild(this.witherShoulders);
        this.witherShoulders.addChild(this.witherRightHead);
        this.ribsJoint.addChild(this.witherRib1);
        this.witherRib2.addChild(this.witherSternum);
        this.witherSpine.addChild(this.ribsJoint);
        this.ribsJoint.addChild(this.witherRib4);
        this.witherShoulders.addChild(this.witherLeftHead);
        this.rootJoint.addChild(this.witherSpine);
        this.ribsJoint.addChild(this.witherRib2);
        this.witherShoulders.addChild(this.witherCenterHead);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.rootJoint).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setRotationAngles(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {}

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
