package com.example.taptadashboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.taptadashboard.databinding.ActivitySplashScreenBinding
import com.example.taptadashboard.onboarding.OnBoardingActivity

class SplashScreen : AppCompatActivity() {

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        Handler().postDelayed({
            val i = Intent(this, OnBoardingActivity::class.java)
            startActivity(i)
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }, 2000)
    }
}