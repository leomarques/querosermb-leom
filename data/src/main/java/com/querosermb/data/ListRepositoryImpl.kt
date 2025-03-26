package com.querosermb.data

class ListRepositoryImpl(private val apiService: CoinApiService) : ListRepository {
    override suspend fun getItems(): APIResponse {
        val exchanges = apiService.getExchanges()
        return exchanges.body() ?: emptyList()
    }
}
