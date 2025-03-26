package com.querosermb.domain.model

import com.querosermb.data.http.ExchangeAPIModel
import com.querosermb.data.local.ExchangeEntity
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter

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

fun ExchangeEntity.toDomain() =
    Exchange(
        exchangeId = exchangeId,
        website = website,
        name = name,
        dataQuoteStart = dataQuoteStart?.toPattern(),
        dataQuoteEnd = dataQuoteEnd?.toPattern(),
        dataOrderbookStart = dataOrderbookStart?.toPattern(),
        dataOrderbookEnd = dataOrderbookEnd?.toPattern(),
        dataTradeStart = dataTradeStart?.toPattern(),
        dataTradeEnd = dataTradeEnd?.toPattern(),
        dataSymbolsCount = dataSymbolsCount,
        volume1hrsUsd = volume1hrsUsd,
        volume1dayUsd = volume1dayUsd,
        volume1mthUsd = volume1mthUsd,
        rank = rank,
    )

fun String.toPattern(): String {
    val inputFormatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val outputFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy - HH:mm:ss")

    return OffsetDateTime.parse(this, inputFormatter).format(outputFormatter)
}
