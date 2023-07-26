package com.example.android_avanzado.data

import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.domain.model.LocationModel

interface HeroRepository {
    suspend fun getHeroList(): List<HeroModel>
    suspend fun getHeroDetailById(id: String): HeroModel
    suspend fun getLocationList(id: String): List<LocationModel>
}