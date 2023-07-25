package com.example.android_avanzado.data.local

import com.example.android_avanzado.data.local.model.HeroLocal

interface LocalDataSource {
    suspend fun insertHeroList(heroList: List<HeroLocal>)
    suspend fun getHeroList(): List<HeroLocal>
}