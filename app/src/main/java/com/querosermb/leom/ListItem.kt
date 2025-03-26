package com.querosermb.leom

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.querosermb.domain.Exchange

@Composable
fun ListItem(
    exchange: Exchange,
    onItemClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier =
            modifier
                .fillMaxWidth()
                .clickable { onItemClick() }
                .padding(16.dp)
    ) {
        Text(text = "Nome: ${exchange.name}")
        Text(text = "ID: ${exchange.exchangeId}")
        Text(text = "Volume em USD em 1 dia: ${exchange.volume1dayUsd}")
    }
}

@Preview(showBackground = true)
@Composable
private fun ListItemPreview() {
    ListItem(
        exchange = previewExchange,
        onItemClick = {}
    )
}
