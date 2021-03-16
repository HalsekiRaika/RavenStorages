package raven.ravenstorages.common.registries.registerer;

import com.google.common.base.CaseFormat;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.transformer.throwables.IllegalClassLoadError;
import raven.ravenstorages.common.handler.RegistrationEventHandler;

import java.util.ArrayList;
import java.util.List;

public class TileEntityRegisterer{
    private static final List<TileEntityType<?>> tiles = new ArrayList<>();
    private final String modId;

    public TileEntityRegisterer(String modId) {
        this.modId = modId;
    }

    public <T extends TileEntity> TileEntityType<T> registry(Class<T> tileClass, Block... bindTarget) {
        String resourceName = tileClass.getSimpleName().substring(4);
               resourceName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, resourceName);
        ResourceLocation rLocation = new ResourceLocation(modId, resourceName);
        TileEntityType.Builder<T> tBuilder = TileEntityType.Builder.create(() -> {
            try { return tileClass.newInstance(); }
            catch (Exception e) {
                e.printStackTrace();
                throw new IllegalClassLoadError("Cannot Instance: " + tileClass.getSimpleName());
            }
        }, bindTarget);

        // DataFixer seems to be used to convert the old NBT data
        // to the new format when loading an old world, so basically null is fine.
        @SuppressWarnings("ConstantConditions")
        TileEntityType<T> type = tBuilder.build(null);
        type.setRegistryName(rLocation);
        RegistrationEventHandler.registration(type);
        return type;
    }

    public static List<TileEntityType<?>> getTiles() {
        return tiles;
    }
}
