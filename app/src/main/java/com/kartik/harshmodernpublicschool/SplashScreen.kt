package com.kartik.harshmodernpublicschool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // splash Screen
        Handler().postDelayed({
            val iNext = Intent(this@SplashScreen, SignInActivity::class.java)
            startActivity(iNext)
            finish()

        },4000)
    }
}