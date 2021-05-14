package ru.ar2code.feature_a_impl_2.api.api

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.ar2code.feature_a_api.FeatureAHelloUseCase
import ru.ar2code.feature_a_impl_2.api.FeatureACustomHelloUseCaseImpl

object FeatureACustomImplKoinModule {
    fun create(): Module {
        return module {
            factory<FeatureAHelloUseCase> { FeatureACustomHelloUseCaseImpl() }
        }
    }
}