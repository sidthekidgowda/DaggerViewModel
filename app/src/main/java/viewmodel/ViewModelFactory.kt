package viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.MapKey
import java.lang.Exception
import java.lang.IllegalArgumentException
import java.lang.RuntimeException
import javax.inject.Inject
import javax.inject.Provider
import kotlin.reflect.KClass

class ViewModelFactory @Inject constructor(
    private val viewModelsMap: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>)
    : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        var viewModelCreator: Provider<out ViewModel>? = viewModelsMap[modelClass]

        if (viewModelCreator == null) {
            for ((key, value) in viewModelsMap) {
                if (modelClass.isAssignableFrom(key)) {
                    viewModelCreator = value
                    break
                }
            }
        }
        if (viewModelCreator == null) {
            throw IllegalArgumentException("Unknown model class: $modelClass")
        }
        try {
            @Suppress("UNCHECK_CAST")
            return viewModelCreator.get() as T
        } catch (e: Exception) {
            throw RuntimeException(e)
        }

    }
}

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)