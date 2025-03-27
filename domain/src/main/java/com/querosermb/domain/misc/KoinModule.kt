package com.querosermb.domain.misc

import com.querosermb.data.misc.dataModule
import com.querosermb.domain.details.DetailsUseCase
import com.querosermb.domain.details.DetailsUseCaseImpl
import com.querosermb.domain.list.ListUseCase
import com.querosermb.domain.list.ListUseCaseImpl
import org.koin.core.context.loadKoinModules
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val domainModule =
    module {
        loadKoinModules(dataModule)

        factoryOf(::ListUseCaseImpl) { bind<ListUseCase>() }
        factoryOf(::DetailsUseCaseImpl) { bind<DetailsUseCase>() }
    }
