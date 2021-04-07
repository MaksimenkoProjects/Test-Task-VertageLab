package com.example.testtaskvertagelab.models

data class Markers(
    val places: List<Place>
)

data class Place(
    val id: Int,
    val lat: Double,
    val lng: Double,
    val name: String
)

