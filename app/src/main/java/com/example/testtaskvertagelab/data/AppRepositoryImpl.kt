package com.example.testtaskvertagelab.data

import com.example.testtaskvertagelab.models.Markers
import com.example.testtaskvertagelab.models.Place
import com.example.testtaskvertagelab.repository.AppRepository
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppRepositoryImpl @Inject constructor(
        val networkClient: NetworkClient
): AppRepository {



    override suspend fun getMarkers(): Markers? {
        return try {
            val result = networkClient.client?.getMarker()?.await()
            result?.body() as Markers
        }catch (e: Exception){
            val markerOne = Place(1, 50.450555, 30.5210808, "Independence Square")
            val markerTwo = Place(2, 50.4475888, 30.5198317, "Khreschatyk Street")
            val markerThree = Place(3, 50.44671, 30.5101755, "National Opera of Ukraine")
            Markers(listOf(markerOne, markerTwo, markerThree))
        }
    }
}


