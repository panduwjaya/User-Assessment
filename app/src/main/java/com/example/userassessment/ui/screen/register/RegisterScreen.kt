package com.example.userassessment.ui.screen.register

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun RegisterScreen(
    onRegisterClick: (name: String, email: String, password: String, role: String) -> Unit,
    onRoleClick: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var role by remember { mutableStateOf("") }

    RegisterScreenContent(
        name = name,
        email = email,
        password = password,
        role = role,
        onNameChange = { name = it },
        onEmailChange = {email = it},
        onPasswordChange = { password = it },
        onRoleClick = onRoleClick,
        onRegisterClick = {
            // Validasi bisa ditambahkan di sini
            onRegisterClick(name, email, password, role)
        }
    )
}
