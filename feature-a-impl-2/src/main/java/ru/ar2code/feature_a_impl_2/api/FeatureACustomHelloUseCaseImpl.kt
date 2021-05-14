package ru.ar2code.feature_a_impl_2.api

import ru.ar2code.feature_a_api.FeatureAHello
import ru.ar2code.feature_a_api.FeatureAHelloUseCase

internal class FeatureACustomHelloUseCaseImpl : FeatureAHelloUseCase {
    override fun run(): FeatureAHello {
        return FeatureAHello("Hello from feature A variant 2. Custom impl!")
    }
}