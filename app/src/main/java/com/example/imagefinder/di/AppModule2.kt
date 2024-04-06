package com.example.imagefinder.di

import com.example.imagefinder.api.ApiService
import com.example.imagefinder.api.ApiService2
import com.example.imagefinder.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule2 {
    @Provides
    @Singleton
    fun provideRetrofitInstance(): ApiService2 =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService2::class.java)
}