package com.querosermb.domain.details

import com.querosermb.domain.model.Exchange

class MockDetailsUseCase : DetailsUseCase {
    override suspend fun getExchange(id: String): Exchange? {
        return Exchange()
    }
}
