package com.example.android_avanzado.domain.usecase

import com.example.android_avanzado.data.HeroRepository
import com.example.android_avanzado.domain.model.LocationModel

class GetLastHeroLocationByIdUseCase(
    private val heroRepository: HeroRepository
) {
    suspend fun invoke(id: String): LocationModel {
        val result = heroRepository.getHeroLocationList(id)
        return if(result.isNotEmpty())
            result.last()
        else
            LocationModel(0.0, 0.0)
    }
}