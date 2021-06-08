package com.dicoding.ratingapp.desain.splashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.dicoding.ratingapp.LoginActivity
import com.dicoding.ratingapp.R

@Suppress("DEPRECATION")
class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

            Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
        } , 3000)
    }
}