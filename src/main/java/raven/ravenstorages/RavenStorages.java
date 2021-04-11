package raven.ravenstorages;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raven.ravenstorages.common.blocks.RavenBlocks;
import raven.ravenstorages.common.blocks.tiles.RavenTiles;

import static raven.ravenstorages.RavenStorages.MOD_ID;

@Mod(MOD_ID)
public class RavenStorages {
    public static final String MOD_ID = "raven_storages";
    public static final Logger LOGGER = LogManager.getLogger();

    public RavenStorages() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        /* 何をしてるか理解できるまでコメントアウト
        CommonProxy proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        proxy.initialization();
        proxy.attachLifeCycle(eventBus);
        */

        eventBus.addGenericListener(Block.class, RavenBlocks::register);
        eventBus.addGenericListener(TileEntityType.class, RavenTiles::register);
    }
}
