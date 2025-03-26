package com.querosermb.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exchange")
data class ExchangeEntity(
    val exchangeId: String? = null,
    val website: String? = null,
    val name: String? = null,
    val dataQuoteStart: String? = null,
    val dataQuoteEnd: String? = null,
    val dataOrderbookStart: String? = null,
    val dataOrderbookEnd: String? = null,
    val dataTradeStart: String? = null,
    val dataTradeEnd: String? = null,
    val dataSymbolsCount: Long? = null,
    val volume1hrsUsd: Double? = null,
    val volume1dayUsd: Double? = null,
    val volume1mthUsd: Double? = null,
    val rank: Long? = null,
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
