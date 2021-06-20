package birsy.goblinsmod.core.capabilities;

import birsy.goblinsmod.core.capabilities.corruption.CorruptionCapability;
import birsy.goblinsmod.core.capabilities.corruption.CrownCorruption;
import birsy.goblinsmod.core.capabilities.corruption.ICrownCorruption;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class Capabilities {
    public static void register() {
        CapabilityManager.INSTANCE.register(ICrownCorruption.class, new CorruptionCapability.CorruptionStorage(), CrownCorruption::new);
    }
}
