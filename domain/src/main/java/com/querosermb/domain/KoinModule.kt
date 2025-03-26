package com.querosermb.domain

import com.querosermb.data.dataModule
import org.koin.core.context.loadKoinModules
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        loadKoinModules(dataModule)

        factoryOf(::ListInteractor)
    }
