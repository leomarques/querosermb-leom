package com.querosermb.leom.details

import com.querosermb.domain.model.Exchange

data class DetailsState(
    val isLoading: Boolean = true,
    val item: Exchange = Exchange(),
)
