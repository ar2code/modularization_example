package ru.ar2code.feature_a_ui

import ru.ar2code.feature_a_api.FeatureADestination

internal class FeatureANavDestination : FeatureADestination {
    override fun getNavigationStartPointResId(): Int {
        return R.id.feature_a_nav_graph
    }

    override fun isFeatureAvailable(): Boolean {
        return true
    }

}