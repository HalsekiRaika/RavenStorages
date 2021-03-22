package raven.ravenstorages.common.registries;

import raven.ravenstorages.Settings;
import raven.ravenstorages.common.registries.registerer.ItemRegisterer;

public class RavenItem {
    private static final ItemRegisterer ITEM_REGISTERER = new ItemRegisterer(Settings.MOD_ID);
}
