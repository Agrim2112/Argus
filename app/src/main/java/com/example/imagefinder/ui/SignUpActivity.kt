package com.example.imagefinder.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagefinder.R
import com.example.imagefinder.databinding.ActivityPlagiarismBinding
import com.example.imagefinder.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private var binding: ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnSignup?.setOnClickListener()
        {
            val intent = Intent(this,CategorySelectionActivity::class.java)
            startActivity(intent)
        }

        binding?.tvlogin?.setOnClickListener()
        {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }
    }
}