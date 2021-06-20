package birsy.goblinsmod.common.entity.boss.king_boss;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.world.World;

public class CorruptedEntity extends MonsterEntity {
    private final LivingEntity transformationEntity;
    private CorruptedKingEntity king;

    public CorruptedEntity(EntityType<? extends MonsterEntity> type, World worldIn, LivingEntity transformationEntityIn) {
        super(type, worldIn);
        this.transformationEntity = transformationEntityIn;
    }

    public void assignKing(CorruptedKingEntity assignedKing) {
        this.king = assignedKing;
    }

    public CorruptedKingEntity getKing() {
        return this.king;
    }
}
