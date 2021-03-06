package com.sample.kotlin_mvvm_hilt_flow_ktor.repository

import com.sample.kotlin_mvvm_hilt_flow_ktor.data.model.User
import com.sample.kotlin_mvvm_hilt_flow_ktor.network.DataState
import com.sample.kotlin_mvvm_hilt_flow_ktor.network.UserService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception
import javax.inject.Inject


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
class MainRepository @Inject constructor(){
    suspend fun getUser(): Flow<DataState<List<User>>> = flow {
        emit(DataState.Loading)
        kotlinx.coroutines.delay(1000)
        try {
            val networkUser = listOf<User>() /*userService.get()*/
            emit(DataState.Success(networkUser))
        } catch (e: Exception) {

        }
    }
}
