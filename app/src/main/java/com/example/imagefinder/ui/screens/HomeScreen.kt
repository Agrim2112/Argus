package com.example.imagefinder.ui.screens

import android.app.AlertDialog
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagefinder.R
import com.example.imagefinder.ui.theme.ImageFinderTheme
import java.util.Locale.Category

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
        .background(colorResource(id = R.color.background_blue)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

            Text(
                text = "Hey Hacker",
                color = colorResource(id = R.color.text_blue),
                modifier = modifier.align(Alignment.CenterHorizontally)
                    .padding(bottom = 24.dp),
                fontSize = 50.sp
            )


        Text(
            text = "Categories",
            color = colorResource(id = R.color.text_blue),
            modifier = Modifier.padding(16.dp)
                .align(Alignment.Start),
            fontSize = 30.sp
        )

        CategoryGrid()
    }
}

@Composable
fun CategoryGrid() {
    Box {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
                    .height(150.dp)
                    .padding(8.dp)
            ) {
                Text(text = "Plagiarism checker")
            }

            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxWidth()
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
        HomeScreen()
    }
}