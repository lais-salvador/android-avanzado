package com.example.android_avanzado.data.remote

import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.data.remote.dto.LocationDto

interface RemoteDataSource {
    suspend fun getHeroList(): List<HeroDto>
    suspend fun getLocationList(id: String): List<LocationDto>
}