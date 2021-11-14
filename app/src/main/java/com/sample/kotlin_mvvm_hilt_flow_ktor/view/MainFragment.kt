package com.sample.kotlin_mvvm_hilt_flow_ktor.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.sample.kotlin_mvvm_hilt_flow_ktor.R
import com.sample.kotlin_mvvm_hilt_flow_ktor.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    private val viewModel: MainViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserData()
    }

}
