package com.example.android_avanzado.data.mappers

import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.domain.model.HeroModel

fun HeroDto.toHeroModel() = HeroModel(
    name = name ?: "",
    photoUrl = photo ?: ""
)