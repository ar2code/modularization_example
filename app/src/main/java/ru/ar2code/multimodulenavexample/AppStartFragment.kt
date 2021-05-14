package ru.ar2code.multimodulenavexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.ext.android.inject
import ru.ar2code.feature_a_api.FeatureADestination
import ru.ar2code.feature_b_api.FeatureBDestination
import ru.ar2code.multimodulenavexample.databinding.AppStartFragmentBinding
import ru.ar2code.navigation_api.AppNavigator

class AppStartFragment : Fragment() {

    private var viewBinding: AppStartFragmentBinding? = null

    private val appNavigator: AppNavigator by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = AppStartFragmentBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.featureAButton?.setOnClickListener {
            appNavigator.navigateTo(FeatureADestination::class.java)
        }

        viewBinding?.featureBButton?.setOnClickListener {
            appNavigator.navigateTo(FeatureBDestination::class.java)
        }
    }
}