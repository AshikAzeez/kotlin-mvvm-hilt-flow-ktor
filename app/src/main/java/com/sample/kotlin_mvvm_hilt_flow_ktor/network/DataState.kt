package com.sample.kotlin_mvvm_hilt_flow_ktor.network


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
sealed class DataState<out R> {

    data class Success<out T>(val data: T) : DataState<T>()
    data class Error(val exception: Exception) : DataState<Nothing>()
    object Loading : DataState<Nothing>()
}
