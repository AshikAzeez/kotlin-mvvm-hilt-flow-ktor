package com.sample.kotlin_mvvm_hilt_flow_ktor.util

import android.text.TextUtils
import android.util.Patterns
import java.util.regex.Pattern


/**
 * @author Ashik
 * Created on 23/11/21 .
 */
object Validator {

    fun validateEmailAndPassword(email: String, password: String): Pair<String, Boolean> {
        if (email.isEmpty() || password.isEmpty()) return "Null or Empty" to false
        if (TextUtils.isDigitsOnly(password)) return "Digit only" to false
        if (!(Patterns.EMAIL_ADDRESS.matcher(email).matches())) return "Not match" to false
        if (email == password) return "Email and password same" to false
        if (password.length in 1..3) return "Password length" to false
        return "" to true
    }

}
