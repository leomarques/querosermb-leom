package com.querosermb.data.http

interface ListRepository {
    suspend fun getItems(): Result<APIResponse>
}
