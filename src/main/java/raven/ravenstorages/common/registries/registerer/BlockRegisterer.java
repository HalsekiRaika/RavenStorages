package raven.ravenstorages.common.registries.registerer;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.registries.ForgeRegistries;
import raven.ravenstorages.common.registries.impl.objects.RegisteredBlock;
import raven.ravenstorages.common.registries.impl.provider.IRavenBlockProvider;
import raven.ravenstorages.common.registries.impl.wrapper.RegistryComplexLazyWrapper;
import raven.ravenstorages.common.registries.impl.wrapper.RegistryComplexWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

@Deprecated
public class BlockRegisterer extends RegistryComplexLazyWrapper<Block, Item> {
    private final List<IRavenBlockProvider> blocks = new ArrayList<>();

    public BlockRegisterer(String modid) {
        super(modid, ForgeRegistries.BLOCKS, ForgeRegistries.ITEMS);
    }

    public RegistryComplexWrapper<Block, BlockItem> register(String name, AbstractBlock.Properties properties) {
        return registerBaseProperties(name, () -> new Block(properties), BlockItem::new);
    }

    public <T extends Block> RegistryComplexWrapper<T, BlockItem> register(String name, Supplier<? extends T> blockSupplier) {
        return registerBaseProperties(name, blockSupplier, BlockItem::new);
    }

    public <T extends Block, R extends BlockItem> RegistryComplexWrapper<T, R> registerBaseProperties(
            String name, Supplier<? extends T> blockSupplier, BiFunction<T, Item.Properties, R> itemCreator) {
        return register(name, blockSupplier, block -> itemCreator.apply(block, ItemRegisterer.getBaseProperties()));
    }

    public <T extends Block, R extends BlockItem> RegistryComplexWrapper<T, R> register(
            String name, Supplier<? extends T> blockSupplier, Function<T, R> itemCreator) {
        RegisteredBlock<T, R> registeredBlock = register(name, blockSupplier, itemCreator, RegisteredBlock::new);
        blocks.add(registeredBlock);
        return registeredBlock;
    }

    public List<IRavenBlockProvider> getAllBlocks() {
        return blocks;
    }
}