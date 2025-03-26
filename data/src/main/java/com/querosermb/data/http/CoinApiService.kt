package com.querosermb.data.http

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoinApiService {
    @Headers("X-CoinAPI-Key: b17546e3-7ec5-4a25-b16c-62c4cdf5877b")
    @GET("v1/exchanges")
    suspend fun getExchanges(): Response<APIResponse>
}
