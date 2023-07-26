package com.example.android_avanzado.domain_usecase

import com.example.android_avanzado.domain.model.LocationModel
import com.keepcoding.androidavanzado.domain.usecase.GetDistanceFroHeroUseCase
import junit.framework.TestCase.assertEquals
import org.junit.Test

class GetDistanceFromHeroUseCaseTest {
    private val losAngelesNewYorkDistance = 3937

    @Test
    fun `test distance between points`(){
        val useCase = GetDistanceFroHeroUseCase()
        val newYork = LocationModel(40.748817, -73.985428)
        val losAngeles = LocationModel(34.052235, -118.243683)

        val res = useCase.invoke(newYork, losAngeles)

        assertEquals(res.toInt(), losAngelesNewYorkDistance)
    }
}