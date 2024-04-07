package com.example.imagefinder.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.imagefinder.databinding.ActivityCategorySelectionBinding

class CategorySelectionActivity : AppCompatActivity() {
    private var binding: ActivityCategorySelectionBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySelectionBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "User")
        val pictureUrl = sharedPreferences.getString("pictureUrl", null)
        binding?.greetingsText?.text = "Hello, $name!"

        Log.d("CategorySelectionActivity", "Picture URL: $pictureUrl, $name")

        if (pictureUrl != null) {
            Glide.with(this)
                .load(pictureUrl)
                .into(binding!!.profileView)
        }

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