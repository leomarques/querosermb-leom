package com.querosermb.leom.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.querosermb.domain.model.Exchange
import com.querosermb.leom.R
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
        Text(text = stringResource(R.string.name, exchange.name.orEmpty()))
        Text(text = stringResource(R.string.id, exchange.exchangeId.orEmpty()))
        Text(text = stringResource(R.string.website, exchange.website.orEmpty()))
        Text(text = stringResource(R.string.rank, exchange.rank.toString()))
        Text(text = stringResource(R.string.volume_em_usd_em_1_hora, exchange.volume1hrsUsd.toString()))
        Text(text = stringResource(R.string.volume_em_usd_em_1_dia, exchange.volume1dayUsd.toString()))
        Text(text = stringResource(R.string.volume_em_usd_em_1_m_s, exchange.volume1mthUsd.toString()))
        Text(text = stringResource(R.string.orderbook_start, exchange.dataOrderbookStart.toString()))
        Text(text = stringResource(R.string.orderbook_end, exchange.dataOrderbookEnd.toString()))
        Text(text = stringResource(R.string.trade_start, exchange.dataTradeStart.toString()))
        Text(text = stringResource(R.string.trade_end, exchange.dataTradeEnd.toString()))
        Text(text = stringResource(R.string.quote_start, exchange.dataQuoteStart.toString()))
        Text(text = stringResource(R.string.quote_end, exchange.dataQuoteEnd.toString()))
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsLayoutPreview() {
    DetailsLayout(
        exchange = previewExchange
    )
}
