package com.querosermb.leom.details

import com.querosermb.domain.model.Exchange

data class DetailsState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val item: Exchange = Exchange(),
)
