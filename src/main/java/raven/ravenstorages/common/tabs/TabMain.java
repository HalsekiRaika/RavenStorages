package raven.ravenstorages.common.tabs;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import raven.ravenstorages.common.registries.RavenItem;

import javax.annotation.Nonnull;

public class TabMain extends ItemGroup {
    public static final TabMain INSTANCE = new TabMain();

    public TabMain() {
        super("raven_storages_main");
    }

    @Nonnull
    @Override
    public ItemStack createIcon() {
        return RavenItem.MANIPULATOR.getItemStack();
    }
}
