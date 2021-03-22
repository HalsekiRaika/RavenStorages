package raven.ravenstorages.common.tab;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import raven.ravenstorages.Settings;
import raven.ravenstorages.common.registries.RavenItem;

public class RavenItemGroups {
    public static final ItemGroup RAVEN_MAIN = new ItemGroup(Settings.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(RavenItem.Manipulator);
        }
    };
}
