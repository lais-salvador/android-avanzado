package com.example.android_avanzado.data.mappers

import com.example.android_avanzado.data.local.model.HeroLocal
import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.domain.model.HeroModel

fun HeroDto.toHeroModel() = HeroModel(
    id = id ?:"",
    name = name ?: "",
    photoUrl = photo ?: "",
    description = description ?: ""
)

fun HeroDto.toHeroLocal() = HeroLocal(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photo ?: "",
    favorite = favorite ?: false,
    description = description ?: ""
)

fun HeroLocal.toHeroModel() = HeroModel(
    id = id,
    name = name,
    photoUrl = photoUrl,
    description = description
)