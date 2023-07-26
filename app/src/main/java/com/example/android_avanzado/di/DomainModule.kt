package com.example.android_avanzado.di

import com.example.android_avanzado.domain.usecase.GetHeroDetailByIdUseCase
import com.example.android_avanzado.domain.usecase.GetHeroListUseCase
import com.example.android_avanzado.domain.usecase.GetLastLocationByIdUseCase
import com.keepcoding.androidavanzado.domain.usecase.GetDistanceFromHeroUseCase
import org.koin.dsl.module


val domainModule = module {
    single { GetHeroListUseCase(get()) }
    single { GetHeroDetailByIdUseCase(get()) }
    single { GetLastLocationByIdUseCase(get()) }
    single { GetDistanceFromHeroUseCase() }
}
