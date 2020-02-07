package com.example.daggerviewmodel.application

import androidx.multidex.MultiDexApplication
import com.example.daggerviewmodel.di.AppComponent
import com.example.daggerviewmodel.di.DaggerAppComponent

class MainApplication : MultiDexApplication() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}