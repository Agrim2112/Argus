package com.example.imagefinder.ui.screens

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.imagefinder.R
import com.example.imagefinder.model.ReverseSearchImageModel
import com.example.imagefinder.ui.Screen
import com.example.imagefinder.ui.theme.ImageFinderTheme


@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ImageViewModel = hiltViewModel(),
    modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
        .background(colorResource(id = R.color.background_blue)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        var reverseSearchImageResponse by remember { mutableStateOf<ReverseSearchImageModel?>(null) }
//
//        // Trigger API call when the screen is first displayed
//        LaunchedEffect(Unit) {
//            viewModel.getReverseSearchImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_VTsTN947wxfPvR6azPju20BotT7BNvh_VZLnjduuNQ&s")
//        }
//
//        // Observe changes in the LiveData from the ViewModel
//        viewModel.ReverseSearchImageResponse.observeForever(){
//            response-> reverseSearchImageResponse = response
//        }
//
//        // Render UI based on API response
//        if (reverseSearchImageResponse != null) {
//            Log.d("Success", reverseSearchImageResponse?.data.toString())
//        } else {
//            // Handle loading or error states
//        }
            Text(
                text = "Hey Hacker",
                color = colorResource(id = R.color.text_blue),
                modifier = modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 24.dp),
                fontSize = 50.sp
            )


        Text(
            text = "Categories",
            color = colorResource(id = R.color.text_blue),
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.Start),
            fontSize = 30.sp
        )

        CategoryGrid(navController)
    }
}

@Composable
fun CategoryGrid(navController: NavController) {
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { navController.navigate(Screen.Plagiarism.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp)
            ) {
                Text(text = "Plagiarism checker")
            }

            Button(
                onClick = { navController.navigate(Screen.DeepFake.route) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp)
            ) {
                Text(text = "DeepFake Identification")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ImageFinderTheme {
        val navController = rememberNavController()
        HomeScreen(navController = navController)
    }
}