package com.querosermb.leom.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.querosermb.domain.model.Exchange
import com.querosermb.leom.misc.previewExchange

@Composable
fun DetailsLayout(
    exchange: Exchange,
    modifier: Modifier = Modifier
) {
    Column(
        modifier =
            modifier
                .fillMaxSize()
                .padding(16.dp)
    ) {
        Text(text = "Nome: ${exchange.name}")
        Text(text = "ID: ${exchange.exchangeId}")
        Text(text = "website: ${exchange.website}")
        Text(text = "Rank: ${exchange.rank}")
        Text(text = "Volume em USD em 1 hora: ${exchange.volume1hrsUsd}")
        Text(text = "Volume em USD em 1 dia: ${exchange.volume1dayUsd}")
        Text(text = "Volume em USD em 1 mês: ${exchange.volume1mthUsd}")
        Text(text = "Orderbook start: ${exchange.dataOrderbookStart}")
        Text(text = "Orderbook end: ${exchange.dataOrderbookEnd}")
        Text(text = "Trade start: ${exchange.dataTradeStart}")
        Text(text = "Trade end: ${exchange.dataTradeEnd}")
        Text(text = "Quote start: ${exchange.dataQuoteStart}")
        Text(text = "Quote end: ${exchange.dataQuoteEnd}")
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsLayoutPreview() {
    DetailsLayout(
        exchange = previewExchange
    )
}
