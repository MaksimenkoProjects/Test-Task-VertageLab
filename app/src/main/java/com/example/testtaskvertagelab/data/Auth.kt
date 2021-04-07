package com.example.testtaskvertagelab.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Auth @Inject constructor() {
    var email: String = ""
    var password: String = ""
}