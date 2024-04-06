package com.example.imagefinder.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagefinder.R
import com.example.imagefinder.databinding.ActivityLoginBinding
import com.example.imagefinder.databinding.ActivitySignUpBinding

class LoginActivity : AppCompatActivity() {
    private var binding: ActivityLoginBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnLogin?.setOnClickListener()
        {
            val intent = Intent(this,CategorySelectionActivity::class.java)
            startActivity(intent)
        }

        binding?.tvSignUp?.setOnClickListener()
        {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}