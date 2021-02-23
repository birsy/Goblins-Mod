package birsy.goblinsmod.client.render.entity.layers;

import birsy.goblinsmod.client.render.entity.model.SanctumiteModel;
import birsy.goblinsmod.common.entity.SanctumiteEntity;
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
import net.minecraft.util.math.MathHelper;

public class SanctumiteGhostLayer<T extends SanctumiteEntity> extends LayerRenderer<T, SanctumiteModel<T>> {
    private final EntityModel<T> sanctumiteModel = new SanctumiteModel<>();
    protected static final ResourceLocation TEXTURE = new ResourceLocation(GoblinsMod.MOD_ID, "textures/entity/sanctumite/sanctumite.png");

    public SanctumiteGhostLayer(IEntityRenderer<T, SanctumiteModel<T>> entityRendererIn) {
        super(entityRendererIn);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        float alpha = 1.0f;
        float offset = 0.05f;
        float wave = MathHelper.sin((ageInTicks + partialTicks * 0.25f) * 0.125f);

        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityTranslucent(TEXTURE));
        this.getEntityModel().copyModelAttributesTo(this.sanctumiteModel);
        this.sanctumiteModel.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
        this.sanctumiteModel.setRotationAngles(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

        matrixStackIn.push();
        for(int i = 0; i < 4; i++) {
            alpha *= 0.6;
            matrixStackIn.translate(0, (wave * 0.125) + 0.5f, 10.0 * offset);
            matrixStackIn.scale(0.8F, 0.8F, 0.8F);
            this.sanctumiteModel.render(matrixStackIn, ivertexbuilder, packedLightIn, LivingRenderer.getPackedOverlay(entitylivingbaseIn, 0), 1.0F, 1.0F, 1.0F, alpha);
        }
        matrixStackIn.pop();
    }
}
