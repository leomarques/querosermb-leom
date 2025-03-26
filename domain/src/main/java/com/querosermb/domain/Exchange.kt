package com.querosermb.domain

data class Exchange(
    val exchangeId: String,
    val website: String,
    val name: String,
    val dataQuoteStart: String,
    val dataQuoteEnd: String,
    val dataOrderbookStart: String,
    val dataOrderbookEnd: String,
    val dataTradeStart: String,
    val dataTradeEnd: String,
    val dataSymbolsCount: Long,
    val volume1hrsUsd: Double,
    val volume1dayUsd: Double,
    val volume1mthUsd: Double,
    val rank: Long,
)
