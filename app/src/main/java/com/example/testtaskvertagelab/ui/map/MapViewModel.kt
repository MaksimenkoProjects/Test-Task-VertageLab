package com.example.testtaskvertagelab.ui.map

import androidx.lifecycle.ViewModel
import com.example.testtaskvertagelab.MainActivity
import javax.inject.Inject

class MapViewModel @Inject constructor(
    val mainActivity: MainActivity
): ViewModel() {

    val testMapText = "This is Test Map Text"

}