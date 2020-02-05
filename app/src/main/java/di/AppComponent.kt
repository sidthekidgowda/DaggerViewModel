package di

import android.app.Application
import com.example.daggerviewmodel.MainActivity
import dagger.BindsInstance
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: Application): AppComponent
    }

    fun inject(activity: MainActivity)
}