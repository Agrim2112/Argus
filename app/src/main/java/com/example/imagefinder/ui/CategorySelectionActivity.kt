package com.example.imagefinder.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.bumptech.glide.Glide
import com.example.imagefinder.R
import com.example.imagefinder.databinding.ActivityCategorySelectionBinding

class CategorySelectionActivity : AppCompatActivity() {
    private var binding: ActivityCategorySelectionBinding? = null
    private lateinit var account: Auth0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategorySelectionBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        // Initialize Auth0
        account = Auth0(
            getString(R.string.com_auth0_client_id),
            getString(R.string.com_auth0_domain)
        )

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

        binding?.logout?.setOnClickListener {
            logout(account = account)
        }
    }

    private fun logout(account: Auth0) {
        WebAuthProvider.logout(account)
            .withScheme("demo")
            .start(this, object: Callback<Void?, AuthenticationException> {
                override fun onSuccess(payload: Void?) {
                    // The user has been logged out!
                    val intent = Intent(this@CategorySelectionActivity, SignUpActivity::class.java)
                    startActivity(intent)
                    finish()
                }

                override fun onFailure(error: AuthenticationException) {
                    // Something went wrong!
                }
            })
    }

}