package com.example.imagefinder.ui

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import com.example.imagefinder.databinding.ActivityDeepfakeBinding
import com.example.imagefinder.model.DeepfakeDetectionResponse
import com.example.imagefinder.model.ReverseSearchImageModel
import dagger.hilt.android.AndroidEntryPoint
import java.io.ByteArrayOutputStream
import java.io.InputStream

@AndroidEntryPoint
class DeepfakeActivity : AppCompatActivity() {
    private var binding :ActivityDeepfakeBinding?=null
    private var selectedUri: Uri? = null
    lateinit var viewModel:ImageViewModel2
    private var deepfakeDetectionResponse: DeepfakeDetectionResponse? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDeepfakeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this)[ImageViewModel2::class.java]

        if (!checkPermissions()) {
            requestPermissions(arrayOf(android.Manifest.permission.READ_EXTERNAL_STORAGE), PERMISSION_REQUEST_CODE)
        }

        val filePickerLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.data?.let { uri ->
                    selectedUri = uri
                    processSelectedFile(uri)
                }
            }
        }

        // Open file picker when button is clicked
        binding?.btnUpload?.setOnClickListener {
            openFilePicker(filePickerLauncher)
        }
    }
    private fun checkPermissions(): Boolean {
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED
    }

    private fun openFilePicker(filePickerLauncher: ActivityResultLauncher<Intent>) {
        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
            addCategory(Intent.CATEGORY_OPENABLE)
            type = "video/*"  // Filter to only show video files
        }
        filePickerLauncher.launch(intent)
    }

    private fun processSelectedFile(uri: Uri) {
        val inputStream = contentResolver.openInputStream(uri)
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)
        val byteBuffer = ByteArrayOutputStream()

        inputStream?.use { input ->
            var bytesRead: Int
            while (input.read(buffer).also { bytesRead = it } != -1) {
                byteBuffer.write(buffer, 0, bytesRead)
            }
        }

        val fileBytes = byteBuffer.toByteArray()
        val base64String = Base64.encodeToString(fileBytes, Base64.DEFAULT)

        val videoBase64 = base64String
        val requestId = "your_request_id"
        val isIOS = false
        val docType = "video"
        val orientation = 0

        viewModel.getDeepfake(videoBase64, requestId, isIOS, docType, orientation)

        viewModel.deepfakeResponse.observe(this) {
            if (it != null) {
                deepfakeDetectionResponse=it
                Log.d("Agrim", deepfakeDetectionResponse?.error_message.toString())
                Log.d("Agrim", deepfakeDetectionResponse?.result.toString())
                Log.d("Agrim", deepfakeDetectionResponse?.doc_type.toString())
                Log.d("Agrim", deepfakeDetectionResponse?.req_id.toString())
                if(deepfakeDetectionResponse?.result.isNullOrEmpty())
                {
                    Toast.makeText(this,deepfakeDetectionResponse?.error_message.toString(),Toast.LENGTH_LONG).show()
                }
                else
                {
                    binding?.tvResult?.text=deepfakeDetectionResponse?.result.toString()
                }
            }
        }
    }

    private fun readBytes(inputStream: InputStream?): ByteArray {
        val byteBuffer = ByteArrayOutputStream()
        val bufferSize = 1024
        val buffer = ByteArray(bufferSize)
        var len: Int
        while (inputStream?.read(buffer).also { len = it!! } != -1) {
            byteBuffer.write(buffer, 0, len)
        }
        return byteBuffer.toByteArray()
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 1001
    }
}