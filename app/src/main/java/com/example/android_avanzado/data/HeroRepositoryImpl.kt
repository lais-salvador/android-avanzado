package com.example.android_avanzado.data

import com.example.android_avanzado.data.mappers.toHeroModel
import com.example.android_avanzado.data.remote.RemoteDataSource
import com.example.android_avanzado.domain.model.HeroModel

class HeroRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): HeroRepository {
    override suspend fun getHeroList(): List<HeroModel> = remoteDataSource.getHeroList().map {
        it.toHeroModel()
    }

}