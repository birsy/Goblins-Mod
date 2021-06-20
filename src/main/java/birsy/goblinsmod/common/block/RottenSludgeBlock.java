package birsy.goblinsmod.common.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class RottenSludgeBlock extends Block {
    public RottenSludgeBlock() {
        super(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BROWN).harvestTool(ToolType.SHOVEL).sound(SoundType.WET_GRASS));
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Vector3d vec3d = entityIn.getMotion();
        entityIn.setMotion(vec3d.x * 0.25, vec3d.y, vec3d.z * 0.25);

        super.onEntityWalk(worldIn, pos, entityIn);
    }
}