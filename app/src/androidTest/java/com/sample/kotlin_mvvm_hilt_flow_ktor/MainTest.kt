package com.sample.kotlin_mvvm_hilt_flow_ktor

import androidx.test.core.app.launchActivity
import com.sample.kotlin_mvvm_hilt_flow_ktor.di.BaseUrl
import com.sample.kotlin_mvvm_hilt_flow_ktor.di.NetworkModule
import com.sample.kotlin_mvvm_hilt_flow_ktor.di.TestData
import com.sample.kotlin_mvvm_hilt_flow_ktor.util.launchFragmentInHiltContainer
import com.sample.kotlin_mvvm_hilt_flow_ktor.view.MainActivity
import com.sample.kotlin_mvvm_hilt_flow_ktor.view.DogFragment
import dagger.Module
import dagger.Provides
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@HiltAndroidTest
class MainTest {

    @Inject
    @TestData
    lateinit var testData: String

    @Inject
    @BaseUrl
    lateinit var baseUrl: String

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    @get:Rule(order = 0)
    var hiltRule = HiltAndroidRule(this)

    /*@get:Rule(order = 1)
    var hiltRule = MainRule(this)*/

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun doSomeTest() {
        assert(testData.isNotEmpty())
    }


    @Test
    fun mainActivityTest() {
        val scenario = launchActivity<MainActivity>()
    }

    @Test
    fun mainFragmentTest() {
        val scenario = launchFragmentInHiltContainer<DogFragment>(factory = fragmentFactory) {

        }
    }
}

@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [NetworkModule::class])
object NetworkModule {

    @Singleton
    @Provides
    @BaseUrl
    fun provideBaseUrl(): String {
        return "192.168.0.100:5555/secure/data/getUser"
    }
}


//Only available in this class
@Module
@TestInstallIn(components = [SingletonComponent::class], replaces = [NetworkModule::class])
object TestAppModule {

    @Singleton
    @Provides
    @TestData
    fun provideData(): String {
        return "This is test"
    }
}
