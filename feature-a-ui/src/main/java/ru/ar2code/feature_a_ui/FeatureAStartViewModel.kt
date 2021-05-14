package ru.ar2code.feature_a_ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.ar2code.feature_a_api.FeatureAHelloUseCase

internal class FeatureAStartViewModel(
    private val helloUseCase: FeatureAHelloUseCase
) : ViewModel() {

    private val helloMutable = MutableLiveData<String>()
    val hello: LiveData<String> = helloMutable

    init {
        sayHello()
    }

    private fun sayHello() {
        val result = helloUseCase.run()
        helloMutable.postValue(result.hello)
    }

}