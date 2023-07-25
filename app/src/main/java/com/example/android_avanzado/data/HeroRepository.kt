package com.example.android_avanzado.data

import com.example.android_avanzado.domain.model.HeroModel

interface HeroRepository {
    suspend fun getHeroList(): List<HeroModel>
}