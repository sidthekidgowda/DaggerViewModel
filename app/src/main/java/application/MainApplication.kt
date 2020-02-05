package application

import androidx.multidex.MultiDexApplication
import di.AppComponent
import di.DaggerAppComponent

class MainApplication : MultiDexApplication() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}