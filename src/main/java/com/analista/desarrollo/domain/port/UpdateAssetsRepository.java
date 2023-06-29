package com.analista.desarrollo.domain.port;

import com.analista.desarrollo.domain.model.Assets;

@FunctionalInterface
public interface UpdateAssetsRepository {
    Assets execute(Assets assets, String serial);

}
