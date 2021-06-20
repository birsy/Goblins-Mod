package birsy.goblinsmod.client.render.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.ResourceLocation;

import java.util.Random;

public class BlinkingEyesLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
    private final Random rand = new Random();
    private final int blinkFrequency;
    private static ResourceLocation eyeTexture;

    private boolean blinking;
    private int blinkLength;
    private int blinkDelay;

    private int prevTicksAlive;

    public BlinkingEyesLayer(IEntityRenderer<T, M> entityRendererIn, ResourceLocation eyeTextureIn, int blinkFrequencyIn) {
        super(entityRendererIn);
        eyeTexture = eyeTextureIn;
        blinkFrequency = blinkFrequencyIn;
    }

    @Override
    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        IVertexBuilder ivertexbuilder = bufferIn.getBuffer(RenderType.getEntityCutout(eyeTexture));
        if (this.prevTicksAlive != entitylivingbaseIn.ticksExisted) {
            this.tick();
        }

        if (!this.blinking) {
            this.getEntityModel().render(matrixStackIn, ivertexbuilder, packedLightIn, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }

        this.prevTicksAlive = entitylivingbaseIn.ticksExisted;
    }

    private void tick() {
        if (this.blinking) {
            if (this.blinkLength > 0) {
                this.blinkLength--;
            } else {
                this.blinking = false;
            }
        } else if (rand.nextInt(this.blinkFrequency) == 0 && this.blinkDelay == 0) {
            this.blinking = true;
            this.blinkLength = rand.nextInt(5) + 5;
            this.blinkDelay = 30;
        }

        if (this.blinkDelay > 0) {
           this.blinkDelay--;
        }
    }
}
