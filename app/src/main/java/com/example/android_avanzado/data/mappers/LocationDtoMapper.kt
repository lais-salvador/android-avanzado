package com.example.android_avanzado.data.mappers

import com.example.android_avanzado.data.remote.dto.LocationDto
import com.example.android_avanzado.domain.model.LocationModel

fun LocationDto.toLocationModel() = LocationModel(
    latitud = latitud!!.toDouble(),
    longitud = longitud!!.toDouble()
)