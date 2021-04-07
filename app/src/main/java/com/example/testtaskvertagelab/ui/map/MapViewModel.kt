package com.example.testtaskvertagelab.ui.map

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testtaskvertagelab.MainActivity
import com.example.testtaskvertagelab.data.AppRepositoryImpl
import com.example.testtaskvertagelab.data.Auth
import com.example.testtaskvertagelab.models.Markers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MapViewModel @Inject constructor(
    val mainActivity: MainActivity,
    val auth: Auth,
    val repository: AppRepositoryImpl
): ViewModel(){

    val markerList = MutableLiveData<Markers>()

    init {
        initMarkers()
    }


    fun initMarkers(){
        viewModelScope.launch(Dispatchers.Main){

            val result = repository.getMarkers()
            Log.e("qwerty", "result size - ${result?.places?.size}")
            if (result != null){
                markerList.value = result
            }
        }
    }

}