package com.example.android_avanzado.domain.usecase

import com.example.android_avanzado.data.HeroRepository

class GetHeroDetailByIdUseCase(private val heroRepository: HeroRepository) {
    suspend fun invoke(id: String) = heroRepository.getHeroDetailById(id)
}