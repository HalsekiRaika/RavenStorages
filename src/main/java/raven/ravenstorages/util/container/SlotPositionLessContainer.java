package raven.ravenstorages.util.container;

import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;

import javax.annotation.Nullable;

/**
 * Slotの座標を管理しないContainerの抽象実装です。
 *
 * <p>このクラスは{@link SlotPositionHoldingContainerScreen}の型引数の基底クラスとして使われる事を想定されており、
 * Containerの実装を一切変更しない、マーカーインターフェースのようなクラスです。しかしこのサブクラスの実装者に対して追加の規約を規定します。
 *
 * <p>ContainerScreenの実装ではContainerのaddSlotメソッドで登録されたスロットが自身の描画される座標を保持している必要があります。
 * しかし、SlotPositionHoldingContainerScreenはSlotの保持する座標を無視して独自の座標管理を行います。
 * 従って、サブクラスの実装者及びその利用者はaddSlotメソッドの呼び出しにおいて、Slotの座標が無視される事に留意してください。
 *
 * <p>サブクラスの実装者は、SlotPositionHoldingContainerScreenが各Slotの座標を計算するためにContainerが管理するSlotの取得を簡単にするための
 * メソッドを定義し、ドキュメントを記述することが強く推奨されます。
 * そのようなメソッドを定義しない場合でもinventorySlotsメソッドにより全てのSlotを取得できますが、その場合はindexとSlotの対応を明示的にドキュメント化すべきです。
 *
 * @see SlotPositionHoldingContainerScreen
 */
public abstract class SlotPositionLessContainer extends Container {

    /**
     * 与えられたtype, windowIDを保持するContainerを生成します。
     *
     * <p>typeはRegistryに登録したContainerTypeを指定します。
     * このコンストラクタはForgeやMinecraftのコードから呼ばれることを想定しており、クライアントから呼ばれるべきではありません。
     *
     * @param type コンテナタイプ
     * @param windowID ウィンドウID
     */
    protected SlotPositionLessContainer(@Nullable ContainerType<?> type, int windowID) {
        super(type, windowID);
    }
}
