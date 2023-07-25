package com.example.android_avanzado.data.remote

import com.example.android_avanzado.data.remote.dto.HeroDto
import com.example.android_avanzado.data.remote.dto.SearchDto
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

const val TOKEN = "eyJraWQiOiJwcml2YXRlIiwiYWxnIjoiSFMyNTYiLCJ0eXAiOiJKV1QifQ.eyJleHBpcmF0aW9uIjo2NDA5MjIxMTIwMCwiZW1haWwiOiJiZWpsQGtlZXBjb2RpbmcuZXMiLCJpZGVudGlmeSI6IjdBQjhBQzRELUFEOEYtNEFDRS1BQTQ1LTIxRTg0QUU4QkJFNyJ9.lehepzhRj4gt7ThkRdsPI9aAEph8SgGLMZOjJ1534jI"
interface SuperHeroApi {
    @POST("api/heros/all")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getHeroList(@Body searchDto: SearchDto): List<HeroDto>
}