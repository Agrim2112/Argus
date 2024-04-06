package com.example.imagefinder.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagefinder.R
import com.example.imagefinder.databinding.ActivityCategorySelectionBinding
import com.example.imagefinder.databinding.ActivitySignUpBinding

class CategorySelectionActivity : AppCompatActivity() {
    private var binding: ActivityCategorySelectionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySelectionBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.cardView1?.setOnClickListener()
        {
            val intent = Intent(this,PlagiarismActivity::class.java)
            startActivity(intent)
        }

        binding?.cardView2?.setOnClickListener()
        {
            val intent = Intent(this,DeepfakeActivity::class.java)
            startActivity(intent)
        }
    }
}