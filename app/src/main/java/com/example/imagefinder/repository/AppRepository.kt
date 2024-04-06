package com.example.imagefinder.repository

import com.example.imagefinder.api.ApiService
import javax.inject.Inject

class AppRepository
@Inject constructor(private val apiService: ApiService){
    suspend fun getReverseSearchImages(image_url:String)=apiService.getReverseSearchImages(image_url)
}