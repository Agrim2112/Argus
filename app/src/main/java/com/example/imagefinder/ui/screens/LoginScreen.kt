package com.example.imagefinder.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.FlowRowScopeInstance.align

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.imagefinder.R
import com.example.imagefinder.ui.theme.ImageFinderTheme

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(color = colorResource(id = R.color.background_blue)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = painterResource(id = R.drawable.front_image),
            contentDescription = "null",
            modifier = Modifier.size(500.dp)
                .padding(bottom = 16.dp)
        )


        Text(
            text = "Plagiarism Checker",
            color = colorResource(id = R.color.text_blue),
            fontSize = 30.sp,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(32.dp)
        )


//        Button(onClick = { /*TODO*/ }) {
//            Text(
//                text = "Log"
//            )
//        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.width(150.dp)
                .height(50.dp)
            ) {
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
