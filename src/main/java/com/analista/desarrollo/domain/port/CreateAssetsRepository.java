package com.analista.desarrollo.domain.port;

import com.analista.desarrollo.domain.model.Assets;

@FunctionalInterface
public interface CreateAssetsRepository {
    Assets execute(Assets assets);
}
