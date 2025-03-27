package com.querosermb.domain.list

import com.querosermb.domain.model.Exchange

interface ListUseCase {
    suspend fun getItems(): Result<List<Exchange>>
}
