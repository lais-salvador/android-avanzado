package com.example.android_avanzado.di

import com.example.android_avanzado.domain.usecase.GetHeroListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun providesGetUseCase(): GetHeroListUseCase{
        return GetHeroListUseCase()
    }
}