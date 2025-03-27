package com.querosermb.leom.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
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
        Text(text = stringResource(R.string.name, exchange.name.orEmpty()))
        Text(text = stringResource(R.string.id, exchange.exchangeId.orEmpty()))
        Text(text = stringResource(R.string.volume_em_usd_em_1_dia, exchange.volume1dayUsd.toString()))
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
