package com.Auty.Auty.UI.Activity.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.Auty.Auty.R
import com.Auty.Auty.AppConfig.BaseConfig.BaseActivity
import com.Auty.Auty.AppConfig.TokenManager.TokenManager
import com.Auty.Auty.UI.Activity.main.MainActivity
import com.Auty.Auty.UI.Activity.start.StartActivity
import com.Auty.Auty.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BaseActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        enableEdgeToEdge()
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSplashAnimation()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

       IntentActivity()
    }

    private fun loadUserData() {

    }

    private fun IntentActivity() {
        val  delayMillis: Long = 1300 // 1,25  second
        val isFirstStart = TokenManager.isFirstStart(this)
        Handler(Looper.getMainLooper()).postDelayed({
            if (isFirstStart == true) {
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent)
                TokenManager.saveFirstStart(this)
                finish()
            } else {
                val intent = Intent(this, StartActivity::class.java)
                startActivity(intent)
                finish()
            }
        }, delayMillis)

    }


    private fun setSplashAnimation() {
        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)
        binding.imageView.startAnimation(topAnimation)
        binding.logoName.startAnimation(bottomAnimation)

    }



}