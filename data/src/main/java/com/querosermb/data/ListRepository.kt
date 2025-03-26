package com.querosermb.data

interface ListRepository {
    suspend fun getItems(): APIResponse
}
