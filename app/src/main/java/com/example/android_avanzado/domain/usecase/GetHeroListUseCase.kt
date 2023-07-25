package com.example.android_avanzado.domain.usecase

import com.example.android_avanzado.data.HeroRepository
import com.example.android_avanzado.domain.model.HeroModel

class GetHeroListUseCase (private val heroRepository: HeroRepository) {
    suspend fun invoke(): List<HeroModel> = heroRepository.getHeroList()
}