package birsy.goblinsmod.common.entity;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class AbstractGoblinEntity extends MonsterEntity {
    private boolean partying;
    private BlockPos jukeboxPosition;

    protected AbstractGoblinEntity(EntityType<? extends MonsterEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public void livingTick() {
        if (this.jukeboxPosition == null || !this.jukeboxPosition.withinDistance(this.getPositionVec(), 3.46D) || !this.world.getBlockState(this.jukeboxPosition).isIn(Blocks.JUKEBOX)) {
            this.partying = false;
            this.jukeboxPosition = null;
        }
        super.livingTick();
    }

    @OnlyIn(Dist.CLIENT)
    public void setPartying(BlockPos pos, boolean isPartying) {
        this.jukeboxPosition = pos;
        this.partying = isPartying;
    }

    @OnlyIn(Dist.CLIENT)
    public boolean isPartying() {
        return this.partying;
    }
}
