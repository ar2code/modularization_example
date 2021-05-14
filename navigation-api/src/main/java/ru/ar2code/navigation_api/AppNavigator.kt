package ru.ar2code.navigation_api

import androidx.lifecycle.LiveData
import ru.ar2code.mutableliveevent.EventArgs

/**
 * Navigator that allows you to hide navigation realization with a help of destination interface [ModuleNavInfo].
 */
interface AppNavigator {

    val navigationDestination: LiveData<EventArgs<ModuleNavInfo>>

    val navigationResDestination: LiveData<EventArgs<Int>>

    fun <T> navigateTo(
        moduleNavInfo: Class<T>
    ) where T : ModuleNavInfo

    fun navigateTo(destination: Int)

    fun <T> resolveModule(moduleNavInfo: Class<T>): ModuleNavInfo? where T : ModuleNavInfo

    fun <T> isCanNavigateTo(moduleNavInfo: Class<T>): Boolean where T : ModuleNavInfo
}