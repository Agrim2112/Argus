package com.example.imagefinder.model

data class DeepfakeRequestBody(
    val doc_base64: String,
    val req_id: String,
    val isIOS: Boolean,
    val doc_type: String,
    val orientation: Int
)