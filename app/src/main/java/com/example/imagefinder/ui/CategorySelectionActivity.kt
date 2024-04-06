package com.example.imagefinder.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.imagefinder.databinding.ActivityCategorySelectionBinding

class CategorySelectionActivity : AppCompatActivity() {
    private var binding: ActivityCategorySelectionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySelectionBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        Log.d("CategorySelectionActivity", "Activity created")

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