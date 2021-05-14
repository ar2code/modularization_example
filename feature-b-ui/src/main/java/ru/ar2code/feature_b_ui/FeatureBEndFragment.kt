package ru.ar2code.feature_b_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ar2code.feature_b_ui.databinding.FeatureBEndFragmentBinding

internal class FeatureBEndFragment : Fragment() {

    private var viewBinding: FeatureBEndFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FeatureBEndFragmentBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding?.finishFeatureB?.setOnClickListener {
            findNavController().navigate(R.id.finishFeatureB)
        }
    }


}