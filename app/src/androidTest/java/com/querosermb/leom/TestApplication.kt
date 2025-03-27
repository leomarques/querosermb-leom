package com.querosermb.leom

import android.app.Application
import com.querosermb.domain.details.DetailsUseCase
import com.querosermb.domain.details.MockDetailsUseCase
import com.querosermb.domain.list.ListUseCase
import com.querosermb.domain.list.MockListUseCase
import com.querosermb.leom.misc.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@TestApplication)
            modules(
                appModule,
                module {
                    factoryOf(::MockListUseCase) { bind<ListUseCase>() }
                    factoryOf(::MockDetailsUseCase) { bind<DetailsUseCase>() }
                }
            )
        }
    }
}
