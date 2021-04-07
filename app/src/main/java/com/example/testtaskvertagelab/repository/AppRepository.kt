package com.example.testtaskvertagelab.repository

import com.example.testtaskvertagelab.models.Markers
import com.google.android.gms.maps.model.LatLng

interface AppRepository {

    suspend fun getMarkers(): Markers?
}