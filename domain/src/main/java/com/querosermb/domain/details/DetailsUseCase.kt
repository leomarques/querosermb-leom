package com.querosermb.domain.details

import com.querosermb.domain.model.Exchange

interface DetailsUseCase {
    suspend fun getExchange(id: String): Exchange?
}
