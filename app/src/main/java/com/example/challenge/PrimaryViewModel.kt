package com.example.challenge

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.challenge.domain.usecases.GetProducts
import com.example.challenge.model.PrimaryModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PrimaryViewModel @Inject constructor(
    private val usecase: GetProducts
): ViewModel() {
    private val _uiState = mutableStateOf(PrimaryModel())
    val uiState :State<PrimaryModel> = _uiState

    fun loadInitialData() {
        viewModelScope.launch {
            try {
                val data = usecase()
                _uiState.value = uiState.value.copy(products = data, failedInLoading = false)
            } catch (error: Error) {
                _uiState.value = uiState.value.copy(failedInLoading = true)
            }
        }
    }
}