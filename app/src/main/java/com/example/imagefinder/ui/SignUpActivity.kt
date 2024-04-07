package com.example.imagefinder.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.auth0.android.Auth0
import com.auth0.android.authentication.AuthenticationAPIClient
import com.auth0.android.authentication.AuthenticationException
import com.auth0.android.callback.Callback
import com.auth0.android.provider.WebAuthProvider
import com.auth0.android.result.Credentials
import com.auth0.android.result.UserProfile
import com.example.imagefinder.R
import com.example.imagefinder.databinding.ActivitySignUpBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private lateinit var account: Auth0
    private var binding: ActivitySignUpBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        account = Auth0(
            getString(R.string.com_auth0_client_id),
            getString(R.string.com_auth0_domain)
        )

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.btnSignup?.setOnClickListener()
        {
//            val intent = Intent(this,CategorySelectionActivity::class.java)
//            startActivity(intent)
            loginWithBrowser()
        }

//        binding?.tvlogin?.setOnClickListener()
//        {
//            val intent = Intent(this,LoginActivity::class.java)
//            startActivity(intent)
//        }
    }

    private fun loginWithBrowser() {
        WebAuthProvider.login(account)
            .withScheme("demo")
            .withScope("openid profile email")
            // Launch the authentication passing the callback where the results will be received
            .start(this, object : Callback<Credentials, AuthenticationException> {
                // Called when there is an authentication failure
                override fun onFailure(exception: AuthenticationException) {
                    // Something went wrong!
                }

                // Called when authentication completed successfully
                override fun onSuccess(credentials: Credentials) {
                    val accessToken = credentials.accessToken

                    showUserProfile(accessToken)

                    // Start CategorySelectionActivity
                    val intent = Intent(this@SignUpActivity, CategorySelectionActivity::class.java)
                    startActivity(intent)
//                    finish()

                    Log.d("LoginActivity", "Login successful, starting CategorySelectionActivity")


                }
            })
    }

//    private fun logout() {
//        WebAuthProvider.logout(account)
//            .withScheme("demo")
//            .start(this, object: Callback<Void?, AuthenticationException> {
//                override fun onSuccess(payload: Void?) {
//                    val intent = Intent(this@SignUpActivity, SignUpActivity::class.java)
//                    startActivity(intent)
//                    finish()
//                    // The user has been logged out!
//                }
//
//                override fun onFailure(error: AuthenticationException) {
//                    // Something went wrong!
//                }
//            })
//    }

    private fun showUserProfile(accessToken: String) {
        val client = AuthenticationAPIClient(account)

        // With the access token, call `userInfo` and get the profile from Auth0.
        client.userInfo(accessToken)
            .start(object : Callback<UserProfile, AuthenticationException> {
                override fun onFailure(exception: AuthenticationException) {
                    // Something went wrong!
                }

                override fun onSuccess(profile: UserProfile) {
                    // We have the user's profile!
                    val email = profile.email
                    val name = profile.name
                    val pictureUrl = profile.pictureURL

                    val sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE)
                    val editor = sharedPreferences.edit()
                    editor.putString("name", name)
                    editor.putString("pictureUrl", pictureUrl)
                    editor.apply()
                }
            })
    }
}