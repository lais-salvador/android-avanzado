package com.example.android_avanzado.data

import com.example.android_avanzado.data.local.LocalDataSource
import com.example.android_avanzado.data.mappers.toHeroLocal
import com.example.android_avanzado.data.mappers.toHeroModel
import com.example.android_avanzado.data.mappers.toLocationModel
import com.example.android_avanzado.data.remote.RemoteDataSource
import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.domain.model.HeroModel
import com.example.android_avanzado.domain.model.LocationModel

class HeroRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
): HeroRepository {
    override suspend fun getHeroList(): List<HeroModel> {
        val localData = localDataSource.getHeroList()

        if(localData.isNotEmpty()){
            return localData.map { it.toHeroModel() }
        }else{
            //Get remoteData
            val remoteData: List<HeroDto> = remoteDataSource.getHeroList()

            val filteredList = remoteData.filter { it.id?.isNotEmpty() == true }
            //Save remoteData
            localDataSource.insertHeroList(remoteData.map{ it.toHeroLocal()} )

            //Transform remoteData to Model
            return remoteData.map{
                it.toHeroModel()
            }
        }
    }

    override suspend fun getHeroDetailById(id: String): HeroModel = localDataSource.getHeroDetailById(id).toHeroModel()
    override suspend fun getHeroLocationList(id: String): List<LocationModel> = remoteDataSource.getHeroLocationList(id).map {
        it.toLocationModel()
    }


}