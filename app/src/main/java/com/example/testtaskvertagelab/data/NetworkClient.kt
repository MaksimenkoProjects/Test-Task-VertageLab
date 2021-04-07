package com.example.testtaskvertagelab.data

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NetworkClient @Inject constructor() {
    var client: ApiService? = null

    init {
        client = Retrofit.Builder()
            .baseUrl("https://2fjd9l3x1l.api.quickmocker.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
            .create(ApiService::class.java)
    }
}