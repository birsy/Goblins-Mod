package birsy.goblinsmod.common.level.gen.surfacebuilder;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;
import java.util.stream.IntStream;

public class RockyForestSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {
    protected PerlinNoiseGenerator field_215435_c;
    protected PerlinNoiseGenerator field_215437_d;

    public RockyForestSurfaceBuilder(Codec<SurfaceBuilderConfig> config) {
        super(config);
    }

    public void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (this.field_215435_c == null || this.field_215437_d == null) {
            SharedSeedRandom sharedseedrandom = new SharedSeedRandom(seed);
            this.field_215435_c = new PerlinNoiseGenerator(sharedseedrandom, IntStream.rangeClosed(-3, 0));
            this.field_215437_d = new PerlinNoiseGenerator(sharedseedrandom, ImmutableList.of(0));
        }

        double d0 = 0.0D;
        double d1 = Math.min(Math.abs(noise), this.field_215435_c.noiseAt((double)x * 0.25D, (double)z * 0.25D, false) * 15.0D);
        if (d1 > 0.0D) {
            double d2 = 0.001953125D;
            double d3 = Math.abs(this.field_215437_d.noiseAt((double)x * 0.001953125D, (double)z * 0.001953125D, false));
            d0 = d1 * d1 * 2.5D;
            double d4 = Math.ceil(d3 * 50.0D) + 14.0D;
            if (d0 > d4) {
                d0 = d4;
            }

            d0 = d0 + 64.0D;
        }

        int i1 = x & 15;
        int i = z & 15;
        BlockState blockstate3 = Blocks.STONE.getDefaultState();
        ISurfaceBuilderConfig isurfacebuilderconfig = biomeIn.getGenerationSettings().getSurfaceBuilderConfig();
        BlockState blockstate4 = isurfacebuilderconfig.getUnder();
        BlockState blockstate = isurfacebuilderconfig.getTop();
        BlockState blockstate1 = blockstate4;
        int j = (int)(noise / 3.0D + 3.0D + random.nextDouble() * 0.25D);
        boolean flag = Math.cos(noise / 3.0D * Math.PI) > 0.0D;
        int k = -1;
        boolean flag1 = false;
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();

        for(int l = Math.max(startHeight, (int)d0 + 1); l >= 0; --l) {
            blockpos$mutable.setPos(i1, l, i);
            if (chunkIn.getBlockState(blockpos$mutable).isAir() && l < (int)d0) {
                chunkIn.setBlockState(blockpos$mutable, defaultBlock, false);
            }

            BlockState blockstate2 = chunkIn.getBlockState(blockpos$mutable);
            if (blockstate2.isAir()) {
                k = -1;
            } else if (blockstate2.matchesBlock(defaultBlock.getBlock())) {
                if (k == -1) {
                    flag1 = false;
                    if (j <= 0) {
                        blockstate3 = Blocks.AIR.getDefaultState();
                        blockstate1 = defaultBlock;
                    } else if (l >= seaLevel - 4 && l <= seaLevel + 1) {
                        blockstate3 = getBlockStateAtPos(blockpos$mutable, random);
                        blockstate1 = blockstate4;
                    }

                    if (l < seaLevel && (blockstate3 == null || blockstate3.isAir())) {
                        blockstate3 = defaultFluid;
                    }

                    k = j + Math.max(0, l - seaLevel);
                    if (l >= seaLevel - 1) {
                        if (l <= seaLevel + 3 + j) {
                            chunkIn.setBlockState(blockpos$mutable, blockstate, false);
                            flag1 = true;
                        } else {
                            BlockState blockstate5;
                            if (l >= 64 && l <= 127) {
                                if (flag) {
                                    blockstate5 = getBlockStateAtPos(blockpos$mutable, random);
                                } else {
                                    blockstate5 = Blocks.STONE.getDefaultState();
                                }
                            } else {
                                blockstate5 = getBlockStateAtPos(blockpos$mutable, random);
                            }

                            chunkIn.setBlockState(blockpos$mutable, blockstate5, false);
                        }
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, blockstate1, false);
                        Block block = blockstate1.getBlock();
                        if (block == Blocks.STONE || block == Blocks.COBBLESTONE || block == Blocks.MOSSY_COBBLESTONE) {
                            chunkIn.setBlockState(blockpos$mutable, getBlockStateAtPos(blockpos$mutable, random), false);
                        }
                    }
                } else if (k > 0) {
                    --k;
                    if (flag1) {
                        chunkIn.setBlockState(blockpos$mutable, getBlockStateAtPos(blockpos$mutable, random), false);
                    } else {
                        chunkIn.setBlockState(blockpos$mutable, Blocks.STONE.getDefaultState(), false);
                    }
                }
            }
        }
    }

    private BlockState getBlockStateAtPos(BlockPos pos, Random rand) {
        Random rand2 = rand;
        rand2.setSeed(pos.getX() + pos.getZ());
        if (rand2.nextBoolean()) {
            return Blocks.STONE.getDefaultState();
        } else {
            
            return rand.nextBoolean() ? Blocks.COBBLESTONE.getDefaultState() : Blocks.MOSSY_COBBLESTONE.getDefaultState();
        }
    }
}
