package raven.ravenstorages.itemgroup;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import raven.ravenstorages.item.RavenItems;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public final class RavenItemGroups {
    private RavenItemGroups() {
        throw new AssertionError();
    }

    public static final ItemGroup RAVEN_MAIN = new ItemGroup(MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RavenItems.MANIPULATOR.get());
        }
    };
}
