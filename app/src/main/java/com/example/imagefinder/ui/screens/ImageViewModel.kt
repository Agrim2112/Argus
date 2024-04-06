package com.example.imagefinder.ui.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagefinder.model.ReverseSearchImageModel
import com.example.imagefinder.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel
@Inject constructor(private val appRepository: AppRepository): ViewModel()
{
    private val fetchReverseSearchImages =MutableLiveData<ReverseSearchImageModel>()
    val ReverseSearchImageResponse:LiveData<ReverseSearchImageModel>
        get()= fetchReverseSearchImages

    init {
    }

    fun getReverseSearchImage(image_url: String) {
        viewModelScope.launch {
            appRepository.getReverseSearchImages(image_url).let { response ->
                if(response.isSuccessful){
                    fetchReverseSearchImages.postValue(response.body())
                }
                else{
                    Log.d("ViewModel","getSearchImageDetails: ${response.errorBody()}")
                }
            }
        }
    }
}