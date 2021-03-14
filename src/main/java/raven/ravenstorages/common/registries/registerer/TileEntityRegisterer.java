package raven.ravenstorages.common.registries.registerer;

import com.google.common.base.CaseFormat;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.transformer.throwables.IllegalClassLoadError;

import java.util.ArrayList;
import java.util.List;

public class TileEntityRegisterer<T extends TileEntity> {
    private final List<TileEntityType<T>> tiles = new ArrayList<>();

    public TileEntityType<T> registry(Class<T> tileClass, Block... bindTarget) {
        String resourceName = (tileClass.getSimpleName());
               resourceName = CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, resourceName);
        ResourceLocation rLocation = new ResourceLocation(resourceName);
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
        this.tiles.add(type);
        type.setRegistryName(rLocation);
        return type;
    }

    public List<TileEntityType<T>> getTiles() {
        return tiles;
    }
}
