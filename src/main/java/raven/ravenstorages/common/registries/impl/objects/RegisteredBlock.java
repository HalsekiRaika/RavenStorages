package raven.ravenstorages.common.registries.impl.objects;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import raven.ravenstorages.common.registries.impl.provider.IRavenBlockProvider;
import raven.ravenstorages.common.registries.impl.wrapper.RegistryComplexWrapper;

import javax.annotation.Nonnull;

public class RegisteredBlock<T extends Block, R extends Item> extends RegistryComplexWrapper<T, R> implements IRavenBlockProvider {
    public RegisteredBlock(RegistryObject<T> registryObjectA, RegistryObject<R> registryObjectB) {
        super(registryObjectA, registryObjectB);
    }
    /** @return T extends Block */
    @Nonnull
    @Override
    public Block getBlock() {
        return getRegistryA();
    }

    /** @return  R extends Item  */
    @Nonnull
    @Override
    public Item getItem() {
        return getRegistryB();
    }
}
