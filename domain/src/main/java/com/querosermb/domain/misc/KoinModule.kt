package com.querosermb.domain.misc

import com.querosermb.data.misc.dataModule
import com.querosermb.domain.details.DetailsInteractor
import com.querosermb.domain.list.ListInteractor
import org.koin.core.context.loadKoinModules
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        loadKoinModules(dataModule)

        factoryOf(::ListInteractor)
        factoryOf(::DetailsInteractor)
    }
