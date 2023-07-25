package com.example.android_avanzado.data.local

import com.example.android_avanzado.data.local.model.HeroLocal

class LocalDataSourceImpl(
    private val heroDao: HeroDao
): LocalDataSource{
    override suspend fun insertHeroList(heroList: List<HeroLocal>) = heroDao.insertAll(heroList)

    override suspend fun getHeroList(): List<HeroLocal> = heroDao.getAll()
}