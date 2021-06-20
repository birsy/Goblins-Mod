package birsy.goblinsmod.client.render.entity.layers;

import birsy.goblinsmod.client.render.entity.model.WitherSkullModel;
import birsy.goblinsmod.common.entity.projectile.NewWitherSkullEntity;
import birsy.goblinsmod.core.GoblinsMod;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;

public class WitherSkullGhostLayer<T extends NewWitherSkullEntity> extends LayerRenderer<T, WitherSkullModel<T>> {
    private final EntityModel<T> skullModel = new WitherSkullModel<>();
    protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/wither/wither.png");

    public WitherSkullGhostLayer(IEntityRenderer<T, WitherSkullModel<T>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float alpha = 1.0f;

        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(TEXTURE));
        this.getEntityModel().copyModelAttributesTo(this.skullModel);
        this.skullModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        matrixStackIn.push();
        for(int i = 0; i < 5; i++) {
            alpha *= 0.5;
            matrixStackIn.translate(0, 0, 0.25);
            matrixStackIn.scale(0.95F, 0.95F, 0.95F);
            this.skullModel.render(matrixStackIn, ivertexbuilder, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0), 1.0F, 1.0F, 1.0F, alpha);
        }
        matrixStackIn.pop();
    }
}
