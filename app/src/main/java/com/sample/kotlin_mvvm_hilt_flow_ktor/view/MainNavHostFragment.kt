package com.sample.kotlin_mvvm_hilt_flow_ktor.view

import android.content.Context
import androidx.navigation.fragment.NavHostFragment
import com.sample.kotlin_mvvm_hilt_flow_ktor.MainFragmentFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@AndroidEntryPoint
class MainNavHostFragment : NavHostFragment() {
    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    override fun onAttach(context: Context) {
        super.onAttach(context)
        childFragmentManager.fragmentFactory = fragmentFactory
    }


}
