package com.example.daggerviewmodel.di

import android.app.Application
import com.example.daggerviewmodel.view.IncrementDecrementFragment
import com.example.daggerviewmodel.view.MainActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }

    fun inject(fragment: IncrementDecrementFragment)
}