package ru.ar2code.multimodulenavexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.navigation.*
import org.koin.android.ext.android.inject
import ru.ar2code.navigation_api.AppNavigator

class MainActivity : AppCompatActivity() {

    private val appNavigator: AppNavigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNavigator()
    }

    private fun initNavigator() {

        appNavigator.navigationDestination.observe(this, Observer {
            it?.data?.let { module ->
                findNavController(R.id.rootNavHostFragment).navigate(module.getNavigationStartPointResId())
            }
        })

        appNavigator.navigationResDestination.observe(this, Observer {
            it?.data?.let { res ->
                findNavController(R.id.rootNavHostFragment).navigate(res)
            }
        })

    }
}