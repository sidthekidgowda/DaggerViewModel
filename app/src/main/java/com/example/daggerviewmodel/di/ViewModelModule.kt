package com.example.daggerviewmodel.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerviewmodel.viewmodel.IncrementDecrementViewModel
import dagger.Binds
import dagger.Module
import com.example.daggerviewmodel.viewmodel.ViewModelFactory
import com.example.daggerviewmodel.viewmodel.ViewModelKey
import dagger.MapKey
import dagger.multibindings.IntoMap
import kotlin.reflect.KClass

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(IncrementDecrementViewModel::class)
    abstract fun bindsIncrementDecrementViewModel(viewModel: IncrementDecrementViewModel): ViewModel
}