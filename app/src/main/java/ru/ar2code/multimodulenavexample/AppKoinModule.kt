package ru.ar2code.multimodulenavexample

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.ar2code.navigation_api.AppNavigator
import ru.ar2code.navigation_impl.KoinAppNavigator

object AppKoinModule {
    fun create(): Module {
        return module {
            single<AppNavigator> { KoinAppNavigator() }
        }
    }
}