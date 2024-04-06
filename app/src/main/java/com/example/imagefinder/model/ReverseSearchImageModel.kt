package com.example.imagefinder.model

data class ReverseSearchImageModel(
    val `data`: List<Data>,
    val parameters: Parameters,
    val request_id: String,
    val status: String
)