package com.sample.kotlin_mvvm_hilt_flow_ktor.util

import android.util.Log
import com.google.common.truth.Truth
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

/**
 * @author Ashik
 * Created on 23/11/21 .
 */
@RunWith(JUnit4::class)
class ValidatorTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun validateEmailAndPassword() {
        val email = "ashik.ka@mobiotics.com"
        val password = "12334545454sdfsdfsd"
        val isValid = Validator.validateEmailAndPassword(email, password)
        println("validateEmailAndPassword" + isValid.first)
        Truth.assertThat(isValid.second).isTrue()
    }
}
