package com.querosermb.data.http

import retrofit2.Response
import retrofit2.http.GET

interface CoinApiService {
    @GET("v1/exchanges")
    suspend fun getExchanges(): Response<APIResponse>
}
