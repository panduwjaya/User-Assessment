package com.example.userassessment.ui.navigation

sealed class Screen(val route: String) {
    object Splash: Screen("splash")
    object Home: Screen("home")
    object Register: Screen("register")
    object Login: Screen("login")
}