package com.example.imagefinder.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagefinder.model.DeepfakeDetectionResponse
import com.example.imagefinder.model.DeepfakeRequestBody
import com.example.imagefinder.model.ReverseSearchImageModel
import com.example.imagefinder.repository.AppRepository
import com.example.imagefinder.repository.AppRepository2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ImageViewModel2
@Inject constructor(private val appRepository: AppRepository2): ViewModel()
{
    private val fetchDetectDeepfake = MutableLiveData<DeepfakeDetectionResponse>()
    val deepfakeResponse: LiveData<DeepfakeDetectionResponse>
        get()= fetchDetectDeepfake

    fun getDeepfake(videoBase64:String, requestId: String, isIOS: Boolean, docType: String, orientation: Int) {
        viewModelScope.launch {
            val requestBody = DeepfakeRequestBody(
                doc_base64 = videoBase64,
                req_id = requestId,
                isIOS = isIOS,
                doc_type = docType,
                orientation = orientation
            )
            appRepository.detectDeepfake(requestBody).let { response ->
                if(response.isSuccessful){
                    fetchDetectDeepfake.postValue(response.body())
                }
                else{
                    Log.d("ViewModel","getSearchImageDetails: ${response.errorBody()}")
                }
            }
        }
    }
}