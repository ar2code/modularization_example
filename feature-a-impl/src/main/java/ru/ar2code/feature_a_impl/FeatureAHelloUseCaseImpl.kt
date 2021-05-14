package ru.ar2code.feature_a_impl

import ru.ar2code.feature_a_api.FeatureAHello
import ru.ar2code.feature_a_api.FeatureAHelloUseCase

/**
 * Pay attention, please, implementation is internal with the exception of api with Koin module.
 */
internal class FeatureAHelloUseCaseImpl : FeatureAHelloUseCase {
    override fun run(): FeatureAHello {
        return FeatureAHello("Hello from feature A variant 1.")
    }
}