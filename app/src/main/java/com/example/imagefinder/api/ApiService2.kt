package com.example.imagefinder.api

import com.example.imagefinder.model.DeepfakeDetectionResponse
import com.example.imagefinder.model.DeepfakeRequestBody
import com.example.imagefinder.model.ReverseSearchImageModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService2 {
        @Headers("token: 9e77fa99fa336a96f12bb5e41e83ff4e", "content-type: application/json")
        @POST("deepfake-detection")
        suspend fun detectDeepfake(@Body requestBody: DeepfakeRequestBody): Response<DeepfakeDetectionResponse>
}