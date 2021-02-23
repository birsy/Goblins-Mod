package birsy.goblinsmod.client.render.entity.model;

import birsy.goblinsmod.common.entity.CobuntoEntity;
import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * CobuntoModel - birse
 * Created using Tabula 8.0.0
 */
@OnlyIn(Dist.CLIENT)
public class IllusionerCapeModel extends Model {
    public ModelRenderer illusionerCape;

    public IllusionerCapeModel() {
        super(RenderType::getEntityCutoutNoCull);

        this.textureWidth = 32;
        this.textureHeight = 32;
        this.illusionerCape = new ModelRenderer(this, 0, 0);
        this.illusionerCape.addBox(-5.5F, 0.0F, -1.0F, 11.0F, 21.0F, 1.0F, 1.0F);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        illusionerCape.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}
