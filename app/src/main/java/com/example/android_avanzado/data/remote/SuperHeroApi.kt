package com.example.android_avanzado.data.remote

import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.data.remote.dto.HeroIdDto
import com.example.android_avanzado.data.remote.dto.LocationDto
import com.example.android_avanzado.data.remote.dto.SearchDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

const val TOKEN = "eyJraWQiOiJwcml2YXRlIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJleHBpcmF0aW9uIjo2NDA5MjIxMTIwMCwiaWRlbnRpZnkiOiI3QUI4QUM0RC1BRDhGLTRBQ0UtQUE0NS0yMUU4NEFFOEJCRTciLCJlbWFpbCI6ImJlamxAa2VlcGNvZGluZy5lcyJ9.JGXxNYLgY2vxM31u2NBCS3ONtPf128DA86tUggxnXv8"
interface SuperHeroApi {
    @POST("api/heros/all")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getHeroList(@Body searchDto: SearchDto): List<HeroDto>

    @POST("api/heros/locations")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getHeroLocationList(@Body id: HeroIdDto): List<LocationDto>
}