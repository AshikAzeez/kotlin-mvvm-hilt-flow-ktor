package com.sample.kotlin_mvvm_hilt_flow_ktor.repository

import com.sample.kotlin_mvvm_hilt_flow_ktor.network.DataState
import retrofit2.Response
import java.lang.Exception


/**
 * @author Ashik
 * Created on 22/11/21 .
 */
abstract class BaseApiResponse {
    suspend fun <T> safeApiCall(apiCall: suspend () -> Response<T>): DataState<T> {
        try {
            val response = apiCall()
            if (response.isSuccessful) {
                val body = response.body()
                body?.let {
                    return DataState.Success(body)
                }
            }
            return error("${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(errorMessage: String): DataState<T> =
        DataState.Error(Exception("Api call failed $errorMessage"))
}
