package com.querosermb.domain.model

import com.querosermb.data.http.ExchangeAPIModel
import com.querosermb.data.local.ExchangeEntity

fun ExchangeEntity.toDomain() =
    Exchange(
        exchangeId = exchangeId,
        website = website,
        name = name,
        dataQuoteStart = dataQuoteStart,
        dataQuoteEnd = dataQuoteEnd,
        dataOrderbookStart = dataOrderbookStart,
        dataOrderbookEnd = dataOrderbookEnd,
        dataTradeStart = dataTradeStart,
        dataTradeEnd = dataTradeEnd,
        dataSymbolsCount = dataSymbolsCount,
        volume1hrsUsd = volume1hrsUsd,
        volume1dayUsd = volume1dayUsd,
        volume1mthUsd = volume1mthUsd,
        rank = rank,
    )

fun ExchangeAPIModel.toExchangeEntity() = ExchangeEntity(
    exchangeId = exchangeId,
    website = website,
    name = name,
    dataQuoteStart = dataQuoteStart,
    dataQuoteEnd = dataQuoteEnd,
    dataOrderbookStart = dataOrderbookStart,
    dataOrderbookEnd = dataOrderbookEnd,
    dataTradeStart = dataTradeStart,
    dataTradeEnd = dataTradeEnd,
    dataSymbolsCount = dataSymbolsCount,
    volume1hrsUsd = volume1hrsUsd,
    volume1dayUsd = volume1dayUsd,
    volume1mthUsd = volume1mthUsd,
    rank = rank,
)
