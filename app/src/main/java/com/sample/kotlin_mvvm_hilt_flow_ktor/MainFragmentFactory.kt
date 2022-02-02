package com.sample.kotlin_mvvm_hilt_flow_ktor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.sample.kotlin_mvvm_hilt_flow_ktor.view.SecondFragment
import javax.inject.Inject


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
class MainFragmentFactory @Inject constructor(
    ///private val fragmentName: String
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            SecondFragment::class.java.name -> SecondFragment()
            else -> super.instantiate(classLoader, className)

        }

    }
}
