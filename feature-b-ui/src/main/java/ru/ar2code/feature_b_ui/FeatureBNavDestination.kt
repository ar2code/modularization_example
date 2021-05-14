package ru.ar2code.feature_b_ui

import ru.ar2code.feature_b_api.FeatureBDestination

internal class FeatureBNavDestination : FeatureBDestination {
    override fun getNavigationStartPointResId(): Int {
        return R.id.feature_b_nav_graph
    }

    override fun isFeatureAvailable(): Boolean {
        return true
    }

}