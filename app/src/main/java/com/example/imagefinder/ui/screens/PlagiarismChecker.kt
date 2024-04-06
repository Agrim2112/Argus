package com.example.imagefinder.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.imagefinder.R
import com.example.imagefinder.ui.theme.ImageFinderTheme

@Composable
fun ImageFinderScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = colorResource(id = R.color.background_blue))
    ) {
        Text(
            text = "Enter an URL for an Image",
            color = colorResource(id = R.color.white)
        )

        OutlinedTextField(
            value = "Enter URL here",
            onValueChange = { },
        )

        Text(
            text = "Results",
            color = colorResource(id = R.color.white)
        )

        LazyColumn {

        }


    }
}

@Preview(showBackground = true)
@Composable
fun ImageFinderScreenPreview() {
    ImageFinderTheme {
        ImageFinderScreen()
    }
}