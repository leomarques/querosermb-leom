package com.querosermb.data

import com.google.gson.annotations.SerializedName

typealias APIResponse = List<ExchangeAPIModel>

data class ExchangeAPIModel(
    @SerializedName("exchange_id")
    val exchangeId: String?,
    val website: String?,
    val name: String?,
    @SerializedName("data_quote_start")
    val dataQuoteStart: String?,
    @SerializedName("data_quote_end")
    val dataQuoteEnd: String?,
    @SerializedName("data_orderbook_start")
    val dataOrderbookStart: String?,
    @SerializedName("data_orderbook_end")
    val dataOrderbookEnd: String?,
    @SerializedName("data_trade_start")
    val dataTradeStart: String?,
    @SerializedName("data_trade_end")
    val dataTradeEnd: String?,
    @SerializedName("data_symbols_count")
    val dataSymbolsCount: Long?,
    @SerializedName("volume_1hrs_usd")
    val volume1hrsUsd: Double?,
    @SerializedName("volume_1day_usd")
    val volume1dayUsd: Double?,
    @SerializedName("volume_1mth_usd")
    val volume1mthUsd: Double?,
    val rank: Long?,
)
