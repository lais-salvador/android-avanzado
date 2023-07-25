package com.example.android_avanzado.data.remote

import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.data.remote.dto.SearchDto

class RemoteDataSourceImpl(private val superHeroApi: SuperHeroApi): RemoteDataSource {
    override suspend fun getHeroList(): List<HeroDto> = superHeroApi.getHeroList(SearchDto())
}