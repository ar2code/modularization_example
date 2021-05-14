package ru.ar2code.feature_a_ui.api

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module
import ru.ar2code.feature_a_api.FeatureADestination
import ru.ar2code.feature_a_ui.FeatureAEndViewModel
import ru.ar2code.feature_a_ui.FeatureANavDestination
import ru.ar2code.feature_a_ui.FeatureAStartViewModel

//Из всего -impl модуля наружу виден только DI объект, вся реализация модуля инкапсулирована.
object FeatureAUiKoinModule {

    fun create(): Module {
        return module {
            viewModel { FeatureAStartViewModel(get()) }
            viewModel { FeatureAEndViewModel(get()) }

            //Регистрируем наш модуль для навигации
            factory<FeatureADestination> { FeatureANavDestination() }
        }
    }
}