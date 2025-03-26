package com.querosermb.leom.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    id: String?,
    modifier: Modifier = Modifier,
    viewModel: DetailsViewModel = koinViewModel()
) {
    val uiState by viewModel.state.collectAsState()

    LaunchedEffect(key1 = id) {
        viewModel.updateId(id)
    }

    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (uiState.isLoading) {
            CircularProgressIndicator()
        } else {
            if (uiState.isError) {
                Text("Something went wrong.")
            } else {
                DetailsLayout(exchange = uiState.item)
            }
        }
    }
}
