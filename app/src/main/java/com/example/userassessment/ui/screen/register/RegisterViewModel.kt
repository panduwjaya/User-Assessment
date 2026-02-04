package com.example.userassessment.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userassessment.data.model.RegisterResponse
import com.example.userassessment.data.repository.UserAssessmentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.example.userassessment.ui.util.Result

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val repository: UserAssessmentRepository
) : ViewModel() {

    private val _registerResult = MutableStateFlow<Result<RegisterResponse>?>(null)
    val registerResult: StateFlow<Result<RegisterResponse>?> = _registerResult

    fun register(name: String,email: String, password: String,role: String) {
        viewModelScope.launch {
            repository.fetchRegister(name,email,password,role) // Sesuaikan dengan method di AuthRepository
                .collect { result ->
                    _registerResult.value = result
                }
        }
    }
}