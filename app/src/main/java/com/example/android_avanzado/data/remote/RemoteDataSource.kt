package com.example.android_avanzado.data.remote

import com.example.android_avanzado.data.remote.dto.HeroDto

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDto>
}