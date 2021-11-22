package com.sample.kotlin_mvvm_hilt_flow_ktor.repository

import com.sample.kotlin_mvvm_hilt_flow_ktor.data.model.DogModel
import com.sample.kotlin_mvvm_hilt_flow_ktor.network.DogService
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@ActivityRetainedScoped
class DogRepository @Inject constructor(private val dogService: DogService) {

    fun getDogsData():Flow<List<DogModel>>{
        return flow {
            val response = dogService.getDog()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }
}
