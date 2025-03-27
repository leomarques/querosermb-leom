package com.querosermb.data.misc

import com.querosermb.data.BuildConfig
import com.querosermb.data.http.CoinApiService
import com.querosermb.data.http.ListRepository
import com.querosermb.data.http.ListRepositoryImpl
import com.querosermb.data.local.MBDatabase
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
        .addInterceptor { chain ->
            chain.proceed(
                chain.request().newBuilder()
                    .header("X-CoinAPI-Key", BuildConfig.API_KEY).build()
            )
        }
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
