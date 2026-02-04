package com.example.userassessment.data.model

import kotlinx.serialization.Serializable

@Serializable
data class LoginResponse(
    val email: String,
    val password: String,
    val accesToken: String
)