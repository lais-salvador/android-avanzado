package com.example.android_avanzado.data.remote.dto

import com.squareup.moshi.Json

data class HeroIdDto(
    @Json(name = "id") val id: String
)