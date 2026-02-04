package com.example.userassessment.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userassessment.data.model.HomeResponse
import com.example.userassessment.data.model.RegisterResponse
import com.example.userassessment.data.repository.UserAssessmentRepository
import com.example.userassessment.ui.util.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserAssessmentRepository
) : ViewModel() {

    private val _homeResult = MutableStateFlow<Result<HomeResponse>?>(null)
    val homeResult: StateFlow<Result<HomeResponse>?> = _homeResult

    fun home() {
        viewModelScope.launch {
            repository.fetchHome()
                .collect { result ->
                    _homeResult.value = result
                }
        }
    }
}