package raven.ravenstorages.util.reference;

import net.minecraft.util.ResourceLocation;

import static raven.ravenstorages.RavenStorages.MOD_ID;

public final class SimpleChestRef {
    /** 透過部分も含んだテクスチャ全体のサイズ */
    public static final int TextureFullSizeX = 256;
    public static final int TextureFullSizeY = 256;

    /** 可視部分のみのテクスチャのサイズ */
    public static final int TextureUISizeX = 176;
    public static final int TextureUISizeY = 166;

    /** チェスト部分の左上からの始点座標 */
    public static final int ChestUIPosX = 62;
    public static final int ChestUIPosY = 17;

    /** プレイヤーのインベントリ部分の左上からの始点座標 */
    public static final int PlayerInvPosX = 8;
    public static final int PlayerInvPosY = 84;

    /** プレイヤーのホットバーインベントリ部分の左上からの始点座標 */
    public static final int HotBarPosX = 8;
    public static final int HotBarPosY = 142;

    public static ResourceLocation getTexture() {
        return new ResourceLocation(MOD_ID, "textures/gui/simple_chest");
    }
}
