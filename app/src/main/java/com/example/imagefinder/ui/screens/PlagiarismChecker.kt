package com.example.imagefinder.ui.screens

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
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
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

@Composable
fun DetailCard(
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
                    text = "Title: " + "title",
                )

                Text (
                    text = "Link: " + "URL",
                )

                Text (
                    text = "Date: " + "date",
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

@Preview(showBackground = true)
@Composable
fun DetailCardPreview() {
    ImageFinderTheme {
        DetailCard()
    }
}