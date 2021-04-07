package com.example.testtaskvertagelab.data

import com.example.testtaskvertagelab.models.Markers
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {

    @Headers("Cache-Control: max-age=640000", "User-Agent: Test-Task-VertageLab")
    @GET("kyiv/places")
    fun getMarker(): Deferred<Response<Markers>>


}