package com.example.imagefinder.ui.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.imagefinder.R
import com.example.imagefinder.model.Data
import com.example.imagefinder.model.ReverseSearchImageModel
import com.example.imagefinder.ui.theme.ImageFinderTheme

@Composable
fun ImageFinderScreen(viewModel: ImageViewModel= hiltViewModel(), modifier: Modifier = Modifier) {

    var value by remember{ mutableStateOf("") }
    Column(
        modifier = modifier
            .background(color = colorResource(id = R.color.background_blue))
    ) {
        Text(
            text = "Enter an URL for an Image",
            color = colorResource(id = R.color.white)
        )

        OutlinedTextField(
            value = value,
            onValueChange = { value=it},
        )

        Text(
            text = "Results",
            color = colorResource(id = R.color.white)
        )

        Button(onClick = { viewModel }) {
            Text(text = "Submit")
        }
//        val reverseSearchImageResponse by viewModel.ReverseSearchImageResponse.
//        reverseSearchImageResponse?.let { response ->
//            LazyColumn {
//                items(response.data) { data ->
//                    DetailCard(data)
//                }
//            }
//        }
        var reverseSearchImageResponse by remember { mutableStateOf<ReverseSearchImageModel?>(null) }

        // Trigger API call when the screen is first displayed
        LaunchedEffect(Unit) {
            viewModel.getReverseSearchImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR_VTsTN947wxfPvR6azPju20BotT7BNvh_VZLnjduuNQ&s")
        }

        // Observe changes in the LiveData from the ViewModel
        viewModel.ReverseSearchImageResponse.observeForever(){
            response-> reverseSearchImageResponse = response
        }

        // Render UI based on API response
//        if (reverseSearchImageResponse != null) {
//            LazyColumn {
//                items(reverseSearchImageResponse?.data ?: emptyList()) { imageData ->
//                    DetailCard(imageData)
//                }
//            }
//            Log.d("Success", reverseSearchImageResponse?.data.toString())
//        } else {
//            // Handle loading or error states
//        }

    }
}

@Composable
fun DetailCard(
    data:Data,
    modifier : Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = modifier
                .padding(8.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = modifier,
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_launcher_foreground),
                    contentDescription = "Domain icon",
                    modifier = Modifier
                        .size(50.dp)
                )

                Spacer(
                    modifier = Modifier
                    .width(20.dp)
                )

                Text(
                    text = "Domain",
                    modifier = modifier
                )

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                )

                IconButton(
                    onClick = { expanded = !expanded },
                    modifier = modifier
                ) {
                    Icon(
                        imageVector = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand"
                    )
                }
            }

            if(expanded) {
                Text (
                    text = "Title: " + data?.title,
                )

                Text (
                    text = "Link: " + data?.link,
                )

                Text (
                    text = "Date: " + data?.date,
                )
            }
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

//@Preview(showBackground = true)
//@Composable
//fun DetailCardPreview() {
//    ImageFinderTheme {
//        DetailCard()
//    }
//}