package com.querosermb.leom

import com.querosermb.domain.Exchange

data class ListState(
    val items: List<Exchange> = emptyList(),
    val isLoading: Boolean = true
)
