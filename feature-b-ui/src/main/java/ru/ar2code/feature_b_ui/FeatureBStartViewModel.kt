package ru.ar2code.feature_b_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ar2code.feature_a_api.FeatureADestination
import ru.ar2code.feature_b_api.FeatureBCurrentTimeUseCase
import ru.ar2code.navigation_api.AppNavigator

internal class FeatureBStartViewModel(
    private val timeUseCase: FeatureBCurrentTimeUseCase,
    private val appNavigator: AppNavigator
) : ViewModel() {

    private val timeMutable = MutableLiveData<Long>()
    val time: LiveData<Long> = timeMutable

    init {
        getTime()
    }

    private fun getTime() {
        val result = timeUseCase.run()
        timeMutable.postValue(result)
    }

    fun navigateToFeatureA() {
        appNavigator.navigateTo(FeatureADestination::class.java)
    }
}