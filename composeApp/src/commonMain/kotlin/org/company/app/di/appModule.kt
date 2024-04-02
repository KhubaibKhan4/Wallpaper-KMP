package org.company.app.di

import org.company.app.domain.repository.Repository
import org.company.app.presentation.viewmodel.MainViewModel
import org.koin.dsl.module

val appModule = module {
    single { Repository() }
    single {
        MainViewModel(repository = get())
    }
}