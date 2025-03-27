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
import androidx.compose.ui.res.stringResource
import com.querosermb.leom.R

@Composable
fun ListScreenTopBar(modifier: Modifier = Modifier) {
    MyTopBar(
        text = stringResource(R.string.list_topbar),
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
        text = stringResource(R.string.exchange_topbar, id.toString()),
        navigationIcon = {
            IconButton(onClick = onBack) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_desc)
                )
            }
        },
    )
}

@OptIn(ExperimentalMaterial3Api::class)
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
