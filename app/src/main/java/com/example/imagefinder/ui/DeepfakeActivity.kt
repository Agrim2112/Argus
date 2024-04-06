package com.example.imagefinder.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.imagefinder.databinding.ActivityDeepfakeBinding

class DeepfakeActivity : AppCompatActivity() {
    private var binding :ActivityDeepfakeBinding?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDeepfakeBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }
}