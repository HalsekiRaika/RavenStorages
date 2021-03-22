package raven.ravenstorages.api.storage;

import net.minecraft.item.Item;

import javax.annotation.Nonnull;

/**
 * アイテムを表すResourceIdentifier。
 */
public enum ItemIdentifier implements ResourceIdentifier<Item> {
    /**
     * シングルトンインスタンス。
     */
    SINGLETON;

    /**
     * オブジェクトの文字列表現を返します。
     *
     * @return このオブジェクトの文字列表現。
     */
    @Override
    @Nonnull
    public String toString() {
        return "Item";
    }
}
