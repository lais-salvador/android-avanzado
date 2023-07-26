package com.example.android_avanzado.data.remote.dto

import com.squareup.moshi.Json

data class LocationDto (
    @Json(name = "id") val id: String?,
    @Json(name = "latitud") val latitud: String?,
    @Json(name = "longitud") val longitud: String?,
    @Json(name = "dateShow") val dateShow: String?,
    @Json(name = "hero") val hero: HeroIdDto?
)

data class HeroIdDto(
    @Json(name = "id") val id: String
)