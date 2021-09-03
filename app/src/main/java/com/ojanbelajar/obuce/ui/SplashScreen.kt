package com.ojanbelajar.obuce.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.SplashScreenBinding
import com.ojanbelajar.obuce.ui.onboard.OnboardActivity
import org.jetbrains.anko.startActivity
import java.util.*
import kotlin.concurrent.schedule

class SplashScreen: AppCompatActivity() {

    lateinit var binding: SplashScreenBinding
    var timer = Timer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        timer.schedule(3000) {
            startActivity<OnboardActivity>()
            finish()
        }
    }

    override fun onPause() {
        timer.cancel()
        super.onPause()
    }
}