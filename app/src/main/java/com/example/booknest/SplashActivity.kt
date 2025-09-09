package com.example.booknest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo: ImageView = findViewById(R.id.logo)
        val booknestText: TextView = findViewById(R.id.booknestText)

        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.translate_animation)
        val textAnimation = AnimationUtils.loadAnimation(this, R.anim.text_animation)

        logo.startAnimation(logoAnimation)
        booknestText.startAnimation(textAnimation)


        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, OnboardingActivity::class.java))
            finish()
        }, 1400)

        logoAnimation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}

            override fun onAnimationEnd(animation: Animation?) {

            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
    }
}
