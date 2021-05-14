package ru.ar2code.navigation_impl

import androidx.lifecycle.LiveData
import org.koin.java.KoinJavaComponent
import ru.ar2code.mutableliveevent.EventArgs
import ru.ar2code.mutableliveevent.MutableLiveEvent
import ru.ar2code.navigation_api.AppNavigator
import ru.ar2code.navigation_api.ModuleNavInfo
import java.lang.Exception

/**
 * Navigator implementation with help of Koin DI (https://insert-koin.io/).
 *
 * Navigator also uses [MutableLiveEvent] to send a navigation event only once time (https://github.com/ar2code/MutableLiveEvent) .
 */
class KoinAppNavigator : AppNavigator {

    private val navigationDestinationInternal = MutableLiveEvent<EventArgs<ModuleNavInfo>>()
    override val navigationDestination =
        navigationDestinationInternal as LiveData<EventArgs<ModuleNavInfo>>

    private val navigationIntDestinationInternal = MutableLiveEvent<EventArgs<Int>>()
    override val navigationResDestination: LiveData<EventArgs<Int>>
        get() = navigationIntDestinationInternal

    override fun <T : ModuleNavInfo> navigateTo(
        moduleNavInfo: Class<T>
    ) {
        val destination = KoinJavaComponent.get(moduleNavInfo) as ModuleNavInfo
        navigationDestinationInternal.postValue(EventArgs(destination))
    }

    override fun navigateTo(destination: Int) {
        navigationIntDestinationInternal.postValue(EventArgs(destination))
    }

    override fun <T : ModuleNavInfo> resolveModule(moduleNavInfo: Class<T>): ModuleNavInfo? {
        return try {
            KoinJavaComponent.get(moduleNavInfo)
        } catch (e: Exception) {
            null
        }
    }

    override fun <T : ModuleNavInfo> isCanNavigateTo(moduleNavInfo: Class<T>): Boolean {
        return resolveModule(moduleNavInfo) != null
    }
}