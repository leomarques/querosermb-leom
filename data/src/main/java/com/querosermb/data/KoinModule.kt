package com.querosermb.data

import okhttp3.OkHttpClient
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule =
    module {
        single { MBDatabase.getInstance(get()).exchangeDao() }
        single { provideRetrofit() }
        single { provideApiService(get()) }
        factoryOf(::ListRepositoryImpl) { bind<ListRepository>() }
    }

private fun provideRetrofit(): Retrofit {
    val okHttpClient = OkHttpClient.Builder()
        .build()

    return Retrofit.Builder()
        .baseUrl("https://rest.coinapi.io/")
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

private fun provideApiService(retrofit: Retrofit): CoinApiService {
    return retrofit.create(CoinApiService::class.java)
}
