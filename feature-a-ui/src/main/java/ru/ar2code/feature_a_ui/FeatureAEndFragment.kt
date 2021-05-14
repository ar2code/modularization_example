package ru.ar2code.feature_a_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ar2code.feature_a_ui.databinding.FeatureAEndFragmentBinding
import ru.ar2code.navigation_api.AppNavigator

/**
 * Pay attention, please, UI is internal with the exception of api with Koin module and navigation graph.
 */
internal class FeatureAEndFragment : Fragment() {

    private val viewModel: FeatureAEndViewModel by viewModel()

    private var viewBinding: FeatureAEndFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FeatureAEndFragmentBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.finishFeatureAButton?.setOnClickListener {
            findNavController().navigate(R.id.finishFeatureA)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

}