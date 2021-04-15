package raven.ravenstorages.capability;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

import javax.annotation.Nullable;

public final class CapabilityDebugHandler {
    private CapabilityDebugHandler() {
        throw new AssertionError();
    }

    private static Capability<DebugHandler> DEBUG_HANDLER_CAPABILITY;

    @CapabilityInject(DebugHandler.class)
    private static void setCapability(Capability<DebugHandler> capability) {
        DEBUG_HANDLER_CAPABILITY = capability;
    }

    public static Capability<DebugHandler> debugHandler() {
        return DEBUG_HANDLER_CAPABILITY;
    }

    public static void register() {
        CapabilityManager.INSTANCE.register(DebugHandler.class, new Capability.IStorage<DebugHandler>() {
            @Nullable
            @Override
            public INBT writeNBT(Capability<DebugHandler> capability, DebugHandler instance, Direction side) {
                return null;
            }

            @Override
            public void readNBT(Capability<DebugHandler> capability, DebugHandler instance, Direction side, INBT nbt) {

            }
        }, DebugHandler::new);
    }

    public static final class DebugHandler {
        public DebugHandler() {}

        public void hello() {
            System.out.println("Hello");
        }
    }
}
