package com.example.testtaskvertagelab.di

import com.example.testtaskvertagelab.MainActivity
import com.example.testtaskvertagelab.di.di_annotation.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton



@Module(includes = [AndroidSupportInjectionModule::class])
interface AppModules {

    @ActivityScope
    @ContributesAndroidInjector(modules = [ActivityModules::class])
    fun mainActivity(): MainActivity

}