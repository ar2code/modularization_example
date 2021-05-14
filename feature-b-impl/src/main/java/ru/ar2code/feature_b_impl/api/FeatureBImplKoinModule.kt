package ru.ar2code.feature_b_impl.api

import org.koin.core.module.Module
import org.koin.dsl.module
import ru.ar2code.feature_b_api.FeatureBCurrentTimeUseCase
import ru.ar2code.feature_b_impl.FeatureBCurrentTimeUseCaseImpl

object FeatureBImplKoinModule {
    fun create(): Module {
        return module {
            factory<FeatureBCurrentTimeUseCase> { FeatureBCurrentTimeUseCaseImpl() }
        }
    }
}