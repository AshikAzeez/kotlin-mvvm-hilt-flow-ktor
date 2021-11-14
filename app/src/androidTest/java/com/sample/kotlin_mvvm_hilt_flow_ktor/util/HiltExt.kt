package com.sample.kotlin_mvvm_hilt_flow_ktor.util

import android.content.ComponentName
import android.content.Intent
import android.os.Bundle
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.fragment.app.testing.FragmentScenario
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.core.internal.deps.dagger.internal.Preconditions
import com.sample.kotlin_mvvm_hilt_flow_ktor.R
import com.sample.kotlin_mvvm_hilt_flow_ktor.view.HiltTestActivity


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
inline fun <reified T : Fragment> launchFragmentInHiltContainer(
    fragmentArgs: Bundle? = null,
    /*@StyleRes themeResId: Int = R.style.FragmentScenarioEmptyFragmentActivityTheme,*/
    crossinline action: Fragment.() -> Unit = {}
) {
    val startActivityIntent = Intent.makeMainActivity(
        ComponentName(
            ApplicationProvider.getApplicationContext(),
            HiltTestActivity::class.java
        )
    )/*.putExtra(FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, themeResId)*/

    ActivityScenario.launch<HiltTestActivity>(startActivityIntent).onActivity { activity ->
        val fragment: Fragment = activity.supportFragmentManager.fragmentFactory.instantiate(
            Preconditions.checkNotNull(T::class.java.classLoader),
            T::class.java.name
        )
        fragment.arguments = fragmentArgs
        activity.supportFragmentManager
            .beginTransaction()
            .add(android.R.id.content, fragment, "")
            .commitNow()

        fragment.action()
    }
}


inline fun <reified T : Fragment> launchFragmentInHiltContainer(
    fragmentArgs: Bundle? = null,
    /*@StyleRes themeResId: Int = R.style.FragmentScenarioEmptyFragmentActivityTheme,*/
    factory: FragmentFactory,
    crossinline action: Fragment.() -> Unit = {}
) {
    val startActivityIntent = Intent.makeMainActivity(
        ComponentName(
            ApplicationProvider.getApplicationContext(),
            HiltTestActivity::class.java
        )
    )/*.putExtra(FragmentScenario.EmptyFragmentActivity.THEME_EXTRAS_BUNDLE_KEY, themeResId)*/

    ActivityScenario.launch<HiltTestActivity>(startActivityIntent).onActivity { activity ->
        activity.supportFragmentManager.fragmentFactory = factory
        val fragment: Fragment = activity.supportFragmentManager.fragmentFactory.instantiate(
            Preconditions.checkNotNull(T::class.java.classLoader),
            T::class.java.name
        )
        fragment.arguments = fragmentArgs

        activity.supportFragmentManager
            .beginTransaction()
            .add(android.R.id.content, fragment, "")
            .commit()

        fragment.action()
    }
}











