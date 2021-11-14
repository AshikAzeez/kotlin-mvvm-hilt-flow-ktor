package com.sample.kotlin_mvvm_hilt_flow_ktor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.kotlin_mvvm_hilt_flow_ktor.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@HiltViewModel
class MainViewModel @Inject constructor(private val mainRepository: MainRepository) : ViewModel() {


    fun getUserData() {
        viewModelScope.launch {
            mainRepository.getUser()
        }
    }
}
