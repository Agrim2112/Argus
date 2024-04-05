package com.example.imagefinder.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.imagefinder.ui.theme.ImageFinderTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Plagiarism Checker"
        )

//        Button(onClick = { /*TODO*/ }) {
//            Text(
//                text = "Log"
//            )
//        }

        Button(onClick = { /*TODO*/ }) {
            Text(text = "Sign In")
        }

//        Text(text = "or Sign In with Google")
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ImageFinderTheme {
        LoginScreen(modifier = Modifier.fillMaxSize())
    }
}
