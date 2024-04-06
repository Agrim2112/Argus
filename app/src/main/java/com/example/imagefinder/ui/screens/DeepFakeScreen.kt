package com.example.imagefinder.ui.screens

import DeepFakeVideoViewModel
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch

@Composable
fun DeepFakeScreen(viewModel: DeepFakeVideoViewModel) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    // Create an ActivityResultLauncher
    val pickVideoLauncher = rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
        // This block will be executed after a video is picked
        scope.launch {
            if (uri != null) {
                viewModel.identifyDeepFake(uri)
            }
        }
    }

    Column {
        Text("Deep Fake Identifier")
        Button(onClick = {
            // Launch the picker when the button is clicked
            pickVideoLauncher.launch("video/*")
        }) {
            Text(text = "Identify Deep Fake")
        }

        val videoUri = viewModel.videoUri.value
        Text(text = "Selected video: $videoUri")

        Text(text = "Results will be displayed here.")
    }
}

@Preview(showBackground = true)
@Composable
fun DeepFakeScreenPreview() {
    DeepFakeScreen(viewModel = DeepFakeVideoViewModel())
}