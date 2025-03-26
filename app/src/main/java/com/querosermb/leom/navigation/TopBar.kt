@file:OptIn(ExperimentalMaterial3Api::class)

package com.querosermb.leom.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListScreenTopBar(modifier: Modifier = Modifier) {
    MyTopBar(
        text = "Lista de Exchanges",
        modifier = modifier
    )
}

@Composable
fun DetailsScreenTopBar(
    id: String?,
    modifier: Modifier = Modifier,
    onBack: () -> Unit
) {
    MyTopBar(
        modifier = modifier,
        text = "Exchange: $id",
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Navigate up"
                )
            }
        },
    )
}

@Composable
fun MyTopBar(
    text: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {}
) {
    TopAppBar(
        modifier = modifier,
        colors =
            TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
        title = {
            Text(text)
        },
        navigationIcon = navigationIcon,
    )
}
