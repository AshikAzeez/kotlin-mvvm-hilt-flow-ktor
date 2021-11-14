package com.sample.kotlin_mvvm_hilt_flow_ktor

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.sample.kotlin_mvvm_hilt_flow_ktor.view.MainFragment
import com.sample.kotlin_mvvm_hilt_flow_ktor.view.UserFragment
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
            MainFragment::class.java.name -> MainFragment(/*fragmentName*/)
            UserFragment::class.java.name->UserFragment(/*fragmentName*/)
            else -> super.instantiate(classLoader, className)

        }

    }
}
