package com.querosermb.domain.list

import com.querosermb.domain.model.Exchange

class MockListUseCase : ListUseCase {
    override suspend fun getItems(): Result<List<Exchange>> {
        return Result.success(
            listOf(
                Exchange(exchangeId = "1", name = "Test Exchange 1"),
                Exchange(exchangeId = "2", name = "Test Exchange 2"),
                Exchange(exchangeId = "3", name = "Test Exchange 3"),
            )
        )
    }
}
