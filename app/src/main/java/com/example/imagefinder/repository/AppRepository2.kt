package com.example.imagefinder.repository

import com.example.imagefinder.api.ApiService
import com.example.imagefinder.api.ApiService2
import com.example.imagefinder.model.DeepfakeRequestBody
import javax.inject.Inject

class AppRepository2
@Inject constructor(private val apiService2: ApiService2){
    suspend fun detect(deepfakeRequestBody:DeepfakeRequestBody)=apiService2.detectDeepfake(deepfakeRequestBody)
}
