package com.example.testtaskvertagelab

import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import dagger.android.support.DaggerAppCompatActivity

class MainActivity : DaggerAppCompatActivity() {

    lateinit var navController: NavController

    val test: String = "Hello"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        androidInjector().inject(this)
        navController = Navigation.findNavController(this, R.id.containerFragment)
    }
}