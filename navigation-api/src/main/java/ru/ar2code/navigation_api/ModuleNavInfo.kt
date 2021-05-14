package ru.ar2code.navigation_api

/**
 * Interface that should be implemented by module we want navigate to.
 */
interface ModuleNavInfo {

    fun getNavigationStartPointResId(): Int

    fun isFeatureAvailable(): Boolean
}