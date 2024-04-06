package com.example.imagefinder.api

import com.example.imagefinder.model.ReverseSearchImageModel
import com.example.imagefinder.utils.Constants.BASE_URL
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @Headers(
        "X-RapidAPI-Key, 59d69812abmsh3000514cc93ed45p19baa7jsnb3bfa31c4d22",
        "X-RapidAPI-Host", "reverse-image-search1.p.rapidapi.com"
        )
    @GET("{image_url}&limit=10")
    suspend fun getReverseSearchImages(@Path("image_url") image_url: String): Response<ReverseSearchImageModel>
}