package ru.ar2code.feature_b_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ar2code.feature_b_ui.databinding.FeatureBStartFragmentBinding
import java.util.*

internal class FeatureBStartFragment : Fragment() {

    private val viewModel: FeatureBStartViewModel by viewModel()

    private var viewBinding: FeatureBStartFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FeatureBStartFragmentBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.time.observe(viewLifecycleOwner, Observer {
            viewBinding?.currentTimeTxt?.text = "Feature B at ${Date(it)}"
        })

        viewBinding?.goToFeatureA?.setOnClickListener {
            viewModel.navigateToFeatureA()
        }

        viewBinding?.goToFeatureBEnd?.setOnClickListener {
            findNavController().navigate(R.id.action_featureBStartFragment_to_featureBEndFragment)
        }
    }

}