package com.querosermb.leom

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    var screen by remember { mutableStateOf(LIST_SCREEN) }

    Scaffold(
        modifier = modifier,
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            when (screen) {
                LIST_SCREEN -> {
                    ListScreen(onItemClick = {
                        screen = DETAIL_SCREEN
                    })
                }

                DETAIL_SCREEN -> {
                    DetailScreen(onBackClick = {
                        screen = LIST_SCREEN
                    })
                }
            }
        }
    }
}
