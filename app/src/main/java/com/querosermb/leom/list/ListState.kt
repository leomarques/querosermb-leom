package com.querosermb.leom.list

import com.querosermb.domain.model.Exchange

data class ListState(
    val items: List<Exchange> = emptyList(),
    val isLoading: Boolean = true,
    val errorMessage: String? = null
)
