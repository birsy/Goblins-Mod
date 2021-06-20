package birsy.goblinsmod.core.capabilities.corruption;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class CrownCorruptionProvider implements ICapabilitySerializable<INBT>
{
    private final CrownCorruption corruption  = new CrownCorruption();
    private final LazyOptional<ICrownCorruption> corruptionOptional = LazyOptional.of(() -> corruption);

    public void invalidate() {
        corruptionOptional.invalidate();
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        return corruptionOptional.cast();
    }

    @Override
    public CompoundNBT serializeNBT() {
        if (CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY == null) {
            return new CompoundNBT();
        } else {
            return (CompoundNBT) CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY.writeNBT(corruption, null);
        }
    }

    @Override
    public void deserializeNBT(INBT nbt) {
        if (CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY != null) {
            CorruptionCapability.ENTITY_CORRUPTION_CAPABILITY.readNBT(corruption, null, nbt);
        }
    }
}
