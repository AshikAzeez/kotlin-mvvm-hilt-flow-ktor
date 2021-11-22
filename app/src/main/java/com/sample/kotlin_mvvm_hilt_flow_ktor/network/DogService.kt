package com.sample.kotlin_mvvm_hilt_flow_ktor.network

import com.sample.kotlin_mvvm_hilt_flow_ktor.data.Constants
import com.sample.kotlin_mvvm_hilt_flow_ktor.data.model.DogModel
import retrofit2.http.GET


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
interface DogService {
    @GET(Constants.DOG_LIST)
    suspend fun getDog(): List<DogModel>
}
