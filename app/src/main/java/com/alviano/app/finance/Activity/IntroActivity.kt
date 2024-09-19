package com.alviano.app.finance.Activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.alviano.app.finance.R
import com.alviano.app.finance.databinding.ActivityIntroBinding

class IntroActivity : AppCompatActivity() {

    lateinit var binding: ActivityIntroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        binding = ActivityIntroBinding.inflate(layoutInflater)
        this.setContentView(binding.root)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.startBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

    }
}