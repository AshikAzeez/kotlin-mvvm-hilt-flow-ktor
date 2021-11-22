package com.sample.kotlin_mvvm_hilt_flow_ktor.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sample.kotlin_mvvm_hilt_flow_ktor.R
import com.sample.kotlin_mvvm_hilt_flow_ktor.viewmodel.DogViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@AndroidEntryPoint
class DogFragment : Fragment(R.layout.fragment_main) {
    private val viewModel: DogViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDogs()
        lifecycleScope.launchWhenStarted {
            viewModel.progressBarFlow.collectLatest {
                if (it) {
                    //Show progress
                } else {
                    //Hide progress
                }
            }
            viewModel.dogsListFlow.collectLatest {
                //Update rv adapter
            }

        }
    }
}
