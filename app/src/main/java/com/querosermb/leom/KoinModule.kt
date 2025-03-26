package com.querosermb.leom

import com.querosermb.domain.domainModule
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val appModule =
    module {
        loadKoinModules(domainModule)

        viewModelOf(::ListViewModel)
    }
