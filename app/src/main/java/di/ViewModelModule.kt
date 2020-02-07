package di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import viewmodel.ViewModelFactory

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory


}