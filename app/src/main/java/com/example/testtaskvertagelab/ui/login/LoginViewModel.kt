package com.example.testtaskvertagelab.ui.login

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testtaskvertagelab.MainActivity
import com.example.testtaskvertagelab.R
import com.example.testtaskvertagelab.data.Auth
import javax.inject.Inject

class LoginViewModel @Inject constructor(
    val mainActivity: MainActivity,
    val auth: Auth
): ViewModel() {


    var editEmailText = MutableLiveData<String>()
    var editPasswordText = MutableLiveData<String>()

    init {
        editEmailText.value = ""
        editPasswordText.value = ""
    }

    fun goToMap(){
        if (editEmailText.value?.length!! >= 5 && editPasswordText.value?.length!! >= 5){
            auth.email = editEmailText.value.toString()
            auth.password = editPasswordText.value.toString()
            mainActivity.navController.navigate(R.id.action_loginFragment_to_mapFragment)
        }else{
            Toast.makeText(mainActivity, "email and password \"<5\" characters", Toast.LENGTH_SHORT).show()
        }


    }

}