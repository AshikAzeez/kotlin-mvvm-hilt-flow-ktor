package com.sample.kotlin_mvvm_hilt_flow_ktor.network

import com.sample.kotlin_mvvm_hilt_flow_ktor.data.model.User
import retrofit2.http.GET


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
interface UserService {
    @GET("")
    suspend fun get(): List<User>
}
