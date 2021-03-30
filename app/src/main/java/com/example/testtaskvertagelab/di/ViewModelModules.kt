package com.example.testtaskvertagelab.di

import androidx.lifecycle.ViewModel
import com.example.testtaskvertagelab.di.di_annotation.ViewModelKey
import com.example.testtaskvertagelab.ui.login.LoginViewModel
import com.example.testtaskvertagelab.ui.map.MapViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
interface ViewModelModules {

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModel(viewModel: LoginViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(MapViewModel::class)
    fun mapViewModel(viewModel: MapViewModel): ViewModel


}