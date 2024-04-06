package com.example.imagefinder.ui.screens

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.imagefinder.ui.AppNavigator
import com.example.imagefinder.ui.theme.ImageFinderTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageFinderTheme {
                val navController = rememberNavController()
                AppNavigator(navController = navController)
            }
        }
    }
}

