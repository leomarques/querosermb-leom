package com.querosermb.leom.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.querosermb.leom.details.DetailsScreen
import com.querosermb.leom.list.ListScreen

const val LIST_SCREEN = "home"
const val DETAIL_SCREEN = "detail"

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    var screen by remember { mutableStateOf(LIST_SCREEN) }
    var id by remember { mutableStateOf<String?>("") }

    Scaffold(
        modifier = modifier,
    ) { paddingValues ->
        Surface(modifier = Modifier.padding(paddingValues)) {
            when (screen) {
                LIST_SCREEN -> {
                    ListScreen(
                        onItemClick = { idParam ->
                            id = idParam
                            screen = DETAIL_SCREEN
                        }
                    )
                }

                DETAIL_SCREEN -> {
                    DetailsScreen(
                        id = id,
                        onBackClick = {
                            screen = LIST_SCREEN
                        }
                    )
                }
            }
        }
    }
}
