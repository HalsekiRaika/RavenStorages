package raven.ravenstorages.common.registries;

import net.minecraft.block.Block;
import raven.ravenstorages.Settings;
import raven.ravenstorages.common.blocks.BlockDebugAnchor;
import raven.ravenstorages.common.registries.registerer.BlockRegisterer;

public class RavenBlock {
    private static final BlockRegisterer<Block> BLOCK_REGISTERER = new BlockRegisterer<>(Settings.MOD_ID);

    public static Block BLOCK_DEBUG;

    public static void regBlock() {
        BLOCK_DEBUG = BLOCK_REGISTERER.registry(BlockDebugAnchor.getInstance());
    }
}
