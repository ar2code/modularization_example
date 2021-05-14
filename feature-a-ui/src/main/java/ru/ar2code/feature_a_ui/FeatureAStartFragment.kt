package ru.ar2code.feature_a_ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.ar2code.feature_a_ui.databinding.FeatureAStartFragmentBinding

internal class FeatureAStartFragment : Fragment() {

    private val viewModel: FeatureAStartViewModel by viewModel()

    private var viewBinding: FeatureAStartFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FeatureAStartFragmentBinding.inflate(inflater, container, false)
        return viewBinding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        viewBinding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.hello.observe(viewLifecycleOwner, Observer {
            viewBinding?.featureaHelloText?.text = it
        })

        viewBinding?.goToEndButton?.setOnClickListener {
            /**
             * You can navigate with a NavComponent inside module if you want.
             */
            findNavController().navigate(R.id.action_featureAStartFragment_to_featureAEndFragment)
        }
    }

}