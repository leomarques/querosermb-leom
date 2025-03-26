package com.querosermb.domain.list

import com.querosermb.data.local.ExchangeDao
import com.querosermb.data.local.ExchangeEntity
import com.querosermb.data.http.ListRepository
import com.querosermb.domain.model.Exchange

class ListInteractor(
    private val listRepository: ListRepository,
    private val exchangeDao: ExchangeDao
) {
    suspend fun getItems(): List<Exchange> {
        val items = listRepository.getItems()

        val exchangeEntities = items.map { item ->
            val exchangeEntity = ExchangeEntity(
                exchangeId = item.exchangeId,
                website = item.website,
                name = item.name,
                dataQuoteStart = item.dataQuoteStart,
                dataQuoteEnd = item.dataQuoteEnd,
                dataOrderbookStart = item.dataOrderbookStart,
                dataOrderbookEnd = item.dataOrderbookEnd,
                dataTradeStart = item.dataTradeStart,
                dataTradeEnd = item.dataTradeEnd,
                dataSymbolsCount = item.dataSymbolsCount,
                volume1hrsUsd = item.volume1hrsUsd,
                volume1dayUsd = item.volume1dayUsd,
                volume1mthUsd = item.volume1mthUsd,
                rank = item.rank,
            )
            exchangeDao.insert(exchangeEntity)
            exchangeEntity
        }

        return exchangeEntities.map { entity ->
            Exchange(
                exchangeId = entity.exchangeId,
                website = entity.website,
                name = entity.name,
                dataQuoteStart = entity.dataQuoteStart,
                dataQuoteEnd = entity.dataQuoteEnd,
                dataOrderbookStart = entity.dataOrderbookStart,
                dataOrderbookEnd = entity.dataOrderbookEnd,
                dataTradeStart = entity.dataTradeStart,
                dataTradeEnd = entity.dataTradeEnd,
                dataSymbolsCount = entity.dataSymbolsCount,
                volume1hrsUsd = entity.volume1hrsUsd,
                volume1dayUsd = entity.volume1dayUsd,
                volume1mthUsd = entity.volume1mthUsd,
                rank = entity.rank,
            )
        }
    }
}
