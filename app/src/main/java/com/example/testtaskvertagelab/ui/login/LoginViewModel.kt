package com.example.testtaskvertagelab.ui.login

import androidx.lifecycle.ViewModel
import com.example.testtaskvertagelab.MainActivity
import com.example.testtaskvertagelab.R
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val mainActivity: MainActivity
): ViewModel() {

    val testText = "This is Test Text"


    fun goToMap(){
        mainActivity.navController.navigate(R.id.action_loginFragment_to_mapFragment)
    }

}