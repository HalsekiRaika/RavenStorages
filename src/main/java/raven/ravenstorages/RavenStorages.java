package raven.ravenstorages;

import net.minecraft.client.gui.ScreenManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import raven.ravenstorages.blocks.RavenBlocks;
import raven.ravenstorages.capability.CapabilityDebugHandler;
import raven.ravenstorages.capability.CapabilityDebugHandler.DebugHandler;
import raven.ravenstorages.capability.SingleCapabilityProvider;
import raven.ravenstorages.client.screen.DebugAnchorScreen;
import raven.ravenstorages.containers.RavenContainers;
import raven.ravenstorages.containers.RavenDefContainers;
import raven.ravenstorages.item.RavenItems;
import raven.ravenstorages.tiles.RavenTiles;

import javax.annotation.Nonnull;

import static raven.ravenstorages.RavenStorages.MOD_ID;
import static raven.ravenstorages.containers.RavenDefContainers.DEBUG_ANCHOR_CONTAINER;

@Mod(MOD_ID)
public final class RavenStorages {
    public static final String MOD_ID = "raven_storages";
    public static final Logger LOGGER = LogManager.getLogger();

    public RavenStorages() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        RavenBlocks.register(modEventBus);
        RavenTiles.register(modEventBus);
        RavenItems.register(modEventBus);
        RavenContainers.register(modEventBus);

        //Deferred
        RavenDefContainers.onRegistration(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;
        forgeEventBus.addGenericListener(ItemStack.class, this::attachItemStackCapability);
    }
    
    private void commonSetup(@Nonnull FMLCommonSetupEvent event) {
        CapabilityDebugHandler.register();
    }

    private void clientSetup(@Nonnull FMLClientSetupEvent event) {
        ScreenManager.registerFactory(DEBUG_ANCHOR_CONTAINER.get(), DebugAnchorScreen::new);
    }

    private void attachItemStackCapability(@Nonnull AttachCapabilitiesEvent<ItemStack> event) {
        ItemStack stack = event.getObject();

        if(!stack.getItem().equals(RavenItems.DEBUGGER.get()))
            return;

        ResourceLocation name = new ResourceLocation(MOD_ID, "debug_handler");
        Capability<DebugHandler> capability = CapabilityDebugHandler.debugHandler();
        DebugHandler instance = new DebugHandler();
        ICapabilityProvider provider = new SingleCapabilityProvider<>(capability, instance);

        event.addCapability(name, provider);
    }
}
