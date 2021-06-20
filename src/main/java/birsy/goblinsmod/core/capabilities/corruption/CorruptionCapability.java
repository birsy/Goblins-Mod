package birsy.goblinsmod.core.capabilities.corruption;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

/**
 * This class is responsible for saving and reading the crown's corruption data from or to server
 */
public class CorruptionCapability {
    @CapabilityInject(ICrownCorruption.class)
    public static Capability<ICrownCorruption> ENTITY_CORRUPTION_CAPABILITY = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(ICrownCorruption.class, new CorruptionStorage(), CrownCorruption::new);
    }

    public static class CorruptionStorage implements Capability.IStorage<ICrownCorruption> {
        @Nullable
        @Override
        public INBT writeNBT(Capability<ICrownCorruption> capability, ICrownCorruption instance, Direction side)
        {
            CompoundNBT tag = new CompoundNBT();
            tag.putDouble("corruption", instance.getCorruption());
            return tag;
        }

        @Override
        public void readNBT(Capability<ICrownCorruption> capability, ICrownCorruption instance, Direction side, INBT nbt)
        {
            double corruption = ((CompoundNBT) nbt).getInt("corruption");
            instance.setCorruption(corruption);
        }
    }
}


