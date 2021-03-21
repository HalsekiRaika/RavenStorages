package raven.ravenstorages.api;

import net.minecraft.tileentity.TileEntity;
import raven.ravenstorages.api.network.StorageNetworkAPI;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Optional;

/**
 * RavenStoragesModの機能にアクセスするためのAPI。
 */
@ParametersAreNonnullByDefault
public interface RavenStoragesAPI {
    /**
     * 指定したタイルエンティティからNetworkAPIを取得します。
     *
     * <p>指定したTileEntityからAPIが取得できない場合Optional.empty()を返します。
     *
     * @param ravenInterface タイルエンティティ
     * @return ネットワークAPI
     */
    Optional<StorageNetworkAPI> getNetworkAPI(TileEntity ravenInterface);
}
