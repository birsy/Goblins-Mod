package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.client.render.util.BirsyModelRenderer;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;

public class CrownModel extends Model {
    public BirsyModelRenderer crown;

    public CrownModel() {
        super(RenderType::getEntityCutoutNoCull);
        this.textureWidth = 64;
        this.textureHeight = 32;

        this.crown = new BirsyModelRenderer(this, 0, 0);
        this.crown.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.crown.addBox(-4.5F, -14.0F, -4.5F, 9.0F, 14.0F, 9.0F, 0.0F, 0.0F, 0.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        crown.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
    }
}
