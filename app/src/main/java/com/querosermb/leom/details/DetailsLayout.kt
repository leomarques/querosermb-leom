package com.querosermb.leom.details

import androidx.compose.foundation.layout.Column
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
    Column(modifier = modifier.padding(16.dp)) {
        Text(text = "Nome: ${exchange.name}")
        Text(text = "ID: ${exchange.exchangeId}")
        Text(text = "Volume em USD em 1 dia: ${exchange.volume1dayUsd}")
        Text(text = "Rank: ${exchange.rank}")
        Text(text = "website: ${exchange.website}")
    }
}

@Preview(showBackground = true)
@Composable
private fun DetailsLayoutPreview() {
    DetailsLayout(
        exchange = previewExchange
    )
}
