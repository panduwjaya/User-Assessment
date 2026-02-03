package com.example.userassessment.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.userassessment.ui.screen.login.LoginScreen
import com.example.userassessment.ui.screen.register.RegisterScreen
import com.example.userassessment.ui.screen.splash.SplashScreen

@Composable
fun UserAssessmentNavigation(
    navController: NavHostController = rememberNavController()
){
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(navController)
        }

        composable(Screen.Login.route) {
            LoginScreen()
            LoginScreen(
                onAddClick = {
                    navController.navigate(Screen.InsertOrder.route)
                },
                onRegistCustomer = {
                    navController.navigate(Screen.RegisterCustomer.route)
                }
            )
        }

        composable(Screen.Home.route) {
            RegisterScreen(
                onAddClick = {
                    navController.navigate(Screen.InsertOrder.route)
                },
                onRegistCustomer = {
                    navController.navigate(Screen.RegisterCustomer.route)
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onAddClick = {
                    navController.navigate(Screen.InsertOrder.route)
                },
                onRegistCustomer = {
                    navController.navigate(Screen.RegisterCustomer.route)
                }
            )
        }
    }


}