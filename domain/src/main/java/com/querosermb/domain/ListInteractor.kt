package com.querosermb.domain

import com.querosermb.data.ListRepository

class ListInteractor(private val listRepository: ListRepository) {
    suspend fun getItems(): List<Exchange> {
        return listRepository.getItems().map {
            Exchange(
                exchangeId = it.exchangeId ?: "",
                website = it.website ?: "",
                name = it.name ?: "",
                dataQuoteStart = it.dataQuoteStart ?: "",
                dataQuoteEnd = it.dataQuoteEnd ?: "",
                dataOrderbookStart = it.dataOrderbookStart ?: "",
                dataOrderbookEnd = it.dataOrderbookEnd ?: "",
                dataTradeStart = it.dataTradeStart ?: "",
                dataTradeEnd = it.dataTradeEnd ?: "",
                dataSymbolsCount = it.dataSymbolsCount ?: 0,
                volume1hrsUsd = it.volume1hrsUsd ?: 0.0,
                volume1dayUsd = it.volume1dayUsd ?: 0.0,
                volume1mthUsd = it.volume1mthUsd ?: 0.0,
                rank = it.rank ?: 0,
            )
        }
    }
}
