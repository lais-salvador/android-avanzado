package com.example.android_avanzado.domain.usecase

import com.example.android_avanzado.domain.model.HeroModel

class GetHeroListUseCase {
    fun invoke(): List<HeroModel> = List<HeroModel>(10){ HeroModel.dummy() }
}