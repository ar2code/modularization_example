package ru.ar2code.feature_a_impl.api

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.ar2code.feature_a_api.FeatureAHelloUseCase

object FeatureAImplKoinModule {
    fun create(): Module {
        return module {
            factory<FeatureAHelloUseCase> { ru.ar2code.feature_a_impl.FeatureAHelloUseCaseImpl() }
        }
    }
}