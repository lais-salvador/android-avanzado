package com.example.android_avanzado.di

import com.example.android_avanzado.data.HeroRepository
import com.example.android_avanzado.data.HeroRepositoryImpl
import com.example.android_avanzado.data.remote.RemoteDataSource
import com.example.android_avanzado.data.remote.RemoteDataSourceImpl
import com.example.android_avanzado.data.remote.SuperHeroApi
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl("https://dragonball.keepcoding.education/")
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<HeroRepository> { HeroRepositoryImpl(get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<SuperHeroApi> {
        getSuperHeroApi(get())
    }
}

private fun getSuperHeroApi(retrofit: Retrofit) =
    retrofit.create(SuperHeroApi::class.java)