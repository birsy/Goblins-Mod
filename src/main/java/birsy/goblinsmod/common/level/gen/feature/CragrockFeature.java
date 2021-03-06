package birsy.goblinsmod.common.level.gen.feature;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.ColumnConfig;
import net.minecraft.world.gen.feature.Feature;

import javax.annotation.Nullable;
import java.util.Random;

public class CragrockFeature extends Feature<ColumnConfig> {
   private static final ImmutableList<Block> invalidBlocks = ImmutableList.of(Blocks.WATER, Blocks.BEDROCK, Blocks.MAGMA_BLOCK, Blocks.SOUL_SAND, Blocks.STONE_BRICKS, Blocks.COBBLESTONE, Blocks.MOSSY_COBBLESTONE, Blocks.OAK_FENCE, Blocks.OAK_LOG, Blocks.OAK_PLANKS, Blocks.OAK_FENCE_GATE, Blocks.CHEST, Blocks.SPAWNER);

   public CragrockFeature(Codec<ColumnConfig> codec) {
      super(codec);
   }

   public boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, ColumnConfig config) {
      int i = generator.getSeaLevel();
      if (!func_242762_a(reader, i, pos.toMutable())) {
         return false;
      } else {
         int j = config.getHeight().getSpread(rand);
         boolean flag = rand.nextFloat() < 0.9F;
         int k = Math.min(j, flag ? 5 : 8);
         int l = flag ? 50 : 15;
         boolean flag1 = false;

         for(BlockPos blockpos : BlockPos.getRandomPositions(rand, l, pos.getX() - k, pos.getY(), pos.getZ() - k, pos.getX() + k, pos.getY(), pos.getZ() + k)) {
            int i1 = j - blockpos.manhattanDistance(pos);
            if (i1 >= 0) {
               flag1 |= this.func_236248_a_(reader, i, blockpos, i1, config.getReach().getSpread(rand), rand);
            }
         }

         return flag1;
      }
   }

   private boolean func_236248_a_(IWorld reader, int seaLevelIn, BlockPos blockposIn, int manhattanDistance, int featureSpreadIn, Random rand) {
      boolean flag = false;

      for(BlockPos blockpos : BlockPos.getAllInBoxMutable(blockposIn.getX() - featureSpreadIn, blockposIn.getY(), blockposIn.getZ() - featureSpreadIn, blockposIn.getX() + featureSpreadIn, blockposIn.getY(), blockposIn.getZ() + featureSpreadIn)) {
         int i = blockpos.manhattanDistance(blockposIn);
         BlockPos blockpos1 = isValidPosition(reader, seaLevelIn, blockpos) ? func_236246_a_(reader, seaLevelIn, blockpos.toMutable(), i) : func_236249_a_(reader, blockpos.toMutable(), i);
         if (blockpos1 != null) {
            int j = manhattanDistance - i / 2;

            for(BlockPos.Mutable blockpos$mutable = blockpos1.toMutable(); j >= 0; --j) {
               if (isValidPosition(reader, seaLevelIn, blockpos$mutable)) {
                  if (rand.nextBoolean()) {
                     if (rand.nextBoolean()) {
                        this.setBlockState(reader, blockpos$mutable, Blocks.MOSSY_COBBLESTONE.getDefaultState());
                     } else {
                        this.setBlockState(reader, blockpos$mutable, Blocks.COBBLESTONE.getDefaultState());
                     }
                  } else {
                     this.setBlockState(reader, blockpos$mutable, Blocks.STONE.getDefaultState());
                  }
                  blockpos$mutable.move(Direction.UP);
                  flag = true;
               } else {
                  if (!reader.getBlockState(blockpos$mutable).matchesBlock(Blocks.BASALT)) {
                     break;
                  }

                  blockpos$mutable.move(Direction.UP);
               }
            }
         }
      }

      return flag;
   }

   @Nullable
   private static BlockPos func_236246_a_(IWorld worldIn, int seaLevelIn, BlockPos.Mutable blockpos$mutable, int manhattanDistanceIn) {
      while(blockpos$mutable.getY() > 1 && manhattanDistanceIn > 0) {
         --manhattanDistanceIn;
         if (func_242762_a(worldIn, seaLevelIn, blockpos$mutable)) {
            return blockpos$mutable;
         }

         blockpos$mutable.move(Direction.DOWN);
      }

      return null;
   }

   private static boolean func_242762_a(IWorld world, int p_242762_1_, BlockPos.Mutable p_242762_2_) {
      if (!isValidPosition(world, p_242762_1_, p_242762_2_)) {
         return false;
      } else {
         BlockState blockstate = world.getBlockState(p_242762_2_.move(Direction.DOWN));
         p_242762_2_.move(Direction.UP);
         return !blockstate.isAir() && !invalidBlocks.contains(blockstate.getBlock());
      }
   }

   @Nullable
   private static BlockPos func_236249_a_(IWorld world, BlockPos.Mutable blockpos$mutable, int manhattenDistanceIn) {
      while(blockpos$mutable.getY() < world.getHeight() && manhattenDistanceIn > 0) {
         --manhattenDistanceIn;
         BlockState blockstate = world.getBlockState(blockpos$mutable);
         if (invalidBlocks.contains(blockstate.getBlock())) {
            return null;
         }

         if (blockstate.isAir()) {
            return blockpos$mutable;
         }

         blockpos$mutable.move(Direction.UP);
      }

      return null;
   }

   private static boolean isValidPosition(IWorld world, int seaLevelIn_, BlockPos blockPos) {
      BlockState blockstate = world.getBlockState(blockPos);
      return blockstate.isAir() || blockstate.matchesBlock(Blocks.WATER) && blockPos.getY() <= seaLevelIn_;
   }
}
