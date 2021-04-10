package raven.ravenstorages;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raven.ravenstorages.client.ClientProxy;
import raven.ravenstorages.common.blocks.RavenBlocks;
import raven.ravenstorages.common.blocks.tiles.RavenTiles;
import raven.ravenstorages.common.proxy.CommonProxy;

import static raven.ravenstorages.Settings.MOD_ID;

@Mod(MOD_ID)
public class RavenStorages {
    public static final Logger LOGGER = LogManager.getLogger();

    private final CommonProxy proxy;

    public RavenStorages() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        this.proxy = DistExecutor.safeRunForDist(() -> ClientProxy::new, () -> CommonProxy::new);
        this.proxy.initialization();
        this.proxy.attachLifeCycle(eventBus);

        eventBus.addGenericListener(Block.class, RavenBlocks::register);
        eventBus.addGenericListener(TileEntityType.class, RavenTiles::register);
    }
}
