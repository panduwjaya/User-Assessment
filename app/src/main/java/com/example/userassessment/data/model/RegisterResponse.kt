package com.example.userassessment.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RegisterResponse(
    val name: String,
    val email: String,
    val password: String,
    val role: String
)