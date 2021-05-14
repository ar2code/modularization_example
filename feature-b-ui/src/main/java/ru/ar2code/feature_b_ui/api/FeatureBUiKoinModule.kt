package ru.ar2code.feature_b_ui.api

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.ar2code.feature_b_api.FeatureBDestination
import ru.ar2code.feature_b_ui.FeatureBEndViewModel
import ru.ar2code.feature_b_ui.FeatureBNavDestination
import ru.ar2code.feature_b_ui.FeatureBStartViewModel

//Из всего -impl модуля наружу виден только DI объект, вся реализация модуля инкапсулирована.
object FeatureBUiKoinModule {

    fun create(): Module {
        return module {
            viewModel { FeatureBStartViewModel(get(), get()) }
            viewModel { FeatureBEndViewModel(get()) }

            //Регистрируем наш модуль для навигации
            factory<FeatureBDestination> { FeatureBNavDestination() }
        }
    }
}