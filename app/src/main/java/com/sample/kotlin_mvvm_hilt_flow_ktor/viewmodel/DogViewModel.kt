package com.sample.kotlin_mvvm_hilt_flow_ktor.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sample.kotlin_mvvm_hilt_flow_ktor.data.model.DogModel
import com.sample.kotlin_mvvm_hilt_flow_ktor.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


/**
 * @author Ashik
 * Created on 14/11/21 .
 */
@HiltViewModel
class DogViewModel @Inject constructor(private val dogRepository: DogRepository) : ViewModel() {
    private val _progressbarFlow: MutableStateFlow<Boolean> by lazy { MutableStateFlow(false) }
    val progressBarFlow get() = _progressbarFlow.asStateFlow()

    private val _dogsListFlow: MutableSharedFlow<List<DogModel>> by lazy { MutableSharedFlow(0) }
    val dogsListFlow get() = _dogsListFlow.asSharedFlow()

    fun getDogs() {
        viewModelScope.launch {
            dogRepository.getDogsData().onStart {
                //Show progress[Use traditional flow]
                _progressbarFlow.emit(true)
            }.catch {
                //Show error message[Use traditional flow]
            }.onCompletion {
                _progressbarFlow.emit(false)
                //On cancel/error
            }.collect {
                _dogsListFlow.emit(it)
            }
        }
    }
}
