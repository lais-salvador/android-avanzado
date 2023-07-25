package com.example.android_avanzado.data.mappers

import com.example.android_avanzado.data.local.model.HeroLocal
import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.domain.model.HeroModel

fun HeroDto.toHeroModel() = HeroModel(
    name = name ?: "",
    photoUrl = photo ?: ""
)

fun HeroDto.toHeroLocal() = HeroLocal(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photo ?: "",
    favorite = favorite ?: false
)

fun HeroLocal.toHeroModel() = HeroModel(
    name = name,
    photoUrl = photoUrl
)