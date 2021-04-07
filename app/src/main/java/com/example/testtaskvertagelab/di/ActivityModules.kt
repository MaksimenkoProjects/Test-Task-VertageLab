package com.example.testtaskvertagelab.di

import com.example.testtaskvertagelab.di.di_annotation.FragmentScope
import com.example.testtaskvertagelab.ui.login.LoginFragment
import com.example.testtaskvertagelab.ui.map.MapFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
interface ActivityModules {


    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModules::class, LoginFragmentModules::class])
    fun loginFragment(): LoginFragment


    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModules::class, MapFragmentModules::class])
    fun mapFragment(): MapFragment


}