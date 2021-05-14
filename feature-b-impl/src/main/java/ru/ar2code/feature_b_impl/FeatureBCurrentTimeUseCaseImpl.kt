package ru.ar2code.feature_b_impl

import ru.ar2code.feature_b_api.FeatureBCurrentTimeUseCase

internal class FeatureBCurrentTimeUseCaseImpl : FeatureBCurrentTimeUseCase {
    override fun run(): Long {
        return System.currentTimeMillis()
    }
}