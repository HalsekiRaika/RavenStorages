package raven.ravenstorages.common.registries;

import raven.ravenstorages.Settings;
import raven.ravenstorages.common.registries.registerer.BlockRegisterer;

public class RavenBlock {
    public static final BlockRegisterer BLOCK_REGISTERER = new BlockRegisterer(Settings.MOD_ID);
}
