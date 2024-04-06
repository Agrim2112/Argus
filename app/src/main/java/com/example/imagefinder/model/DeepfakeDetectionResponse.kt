package com.example.imagefinder.model

data class DeepfakeDetectionResponse(
    val doc_type: String,
    val error_message: Any,
    val req_id: String,
    val result: String,
    val success: Boolean
)