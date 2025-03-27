package com.querosermb.domain.list

import com.querosermb.domain.model.Exchange

class MockListUseCase : ListUseCase {
    override suspend fun getItems(): Result<List<Exchange>> {
        return Result.success(
            listOf(
                Exchange(),
                Exchange(),
                Exchange()
            )
        )
    }
}
