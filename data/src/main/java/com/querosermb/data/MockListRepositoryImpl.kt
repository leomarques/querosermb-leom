package com.querosermb.data

import kotlinx.coroutines.delay

class MockListRepositoryImpl : ListRepository {
    override suspend fun getItems(): APIResponse {
        delay(1000)

        return listOf(
            ExchangeAPIModel(
                exchangeId = "1",
                website = "www.google.com",
                name = "Google",
                dataQuoteStart = "2022-01-01",
                dataQuoteEnd = "2022-01-01",
                dataOrderbookStart = "2022-01-01",
                dataOrderbookEnd = "2022-01-01",
                dataTradeStart = "2022-01-01",
                dataTradeEnd = "2022-01-01",
                dataSymbolsCount = 1,
                volume1hrsUsd = 1.0,
                volume1dayUsd = 1.0,
                volume1mthUsd = 1.0,
                rank = 1
            ),
            ExchangeAPIModel(
                exchangeId = "2",
                website = "www.google.com",
                name = "CoinBase",
                dataQuoteStart = "2022-01-01",
                dataQuoteEnd = "2022-01-01",
                dataOrderbookStart = "2022-01-01",
                dataOrderbookEnd = "2022-01-01",
                dataTradeStart = "2022-01-01",
                dataTradeEnd = "2022-01-01",
                dataSymbolsCount = 1,
                volume1hrsUsd = 1.0,
                volume1dayUsd = 2.0,
                volume1mthUsd = 1.0,
                rank = 1
            ),
            ExchangeAPIModel(
                exchangeId = "3",
                website = "www.google.com",
                name = "CoinAPI",
                dataQuoteStart = "2022-01-01",
                dataQuoteEnd = "2022-01-01",
                dataOrderbookStart = "2022-01-01",
                dataOrderbookEnd = "2022-01-01",
                dataTradeStart = "2022-01-01",
                dataTradeEnd = "2022-01-01",
                dataSymbolsCount = 1,
                volume1hrsUsd = 1.0,
                volume1dayUsd = 3.0,
                volume1mthUsd = 1.0,
                rank = 1
            ),
        )
    }
}
