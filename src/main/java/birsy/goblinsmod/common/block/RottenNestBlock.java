package birsy.goblinsmod.common.block;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.Entity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.ToolType;

import java.util.Random;

public class RottenNestBlock extends DirectionalBlock {
    public static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public RottenNestBlock() {
        super(AbstractBlock.Properties.create(Material.ORGANIC, MaterialColor.BROWN).harvestTool(ToolType.SHOVEL).sound(SoundType.WET_GRASS).hardnessAndResistance(20.0f).tickRandomly());
    }

    @Override
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        super.randomTick(state, worldIn, pos, random);
    }

    @Override
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        Vector3d vec3d = entityIn.getMotion();
        entityIn.setMotion(vec3d.x * 0.25, vec3d.y, vec3d.z * 0.25);

        super.onEntityWalk(worldIn, pos, entityIn);
    }

    @Override
    public void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(FACING, OPEN);
    }
}
