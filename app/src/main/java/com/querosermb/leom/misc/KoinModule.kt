package com.querosermb.leom.misc

import com.querosermb.domain.misc.domainModule
import com.querosermb.leom.details.DetailsViewModel
import com.querosermb.leom.list.ListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

val appModule =
    module {
        loadKoinModules(domainModule)

        viewModelOf(::ListViewModel)
        viewModelOf(::DetailsViewModel)
    }
