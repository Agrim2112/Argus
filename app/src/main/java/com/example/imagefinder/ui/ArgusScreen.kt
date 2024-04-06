package com.example.imagefinder.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.imagefinder.ui.screens.HomeScreen
import com.example.imagefinder.ui.screens.LoginScreen

enum class Screen(val route: String) {
    Login("login"),
    Home("home"),
    DeepFake("deepfake"),
    Plagiarism("plagiarism")
}

    @Composable
    fun AppNavigator(navController: NavHostController) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.Login.route) {
            composable(Screen.Login.route) {
                LoginScreen(navController)
            }
            composable(Screen.Home.route) {
                HomeScreen(navController)
            }
//            composable(Screen.DeepFake.route) {
//                DeepFakeScreen(navController)
//            }
//            composable(Screen.Plagiarism.route) {
//                PlagiarismScreen(navController)
//            }
        }
    }

