package com.ojanbelajar.obuce.ui.getstarted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ojanbelajar.obuce.databinding.ActivityComingSoonBinding

class ComingSoonActivity : AppCompatActivity() {

    lateinit var binding: ActivityComingSoonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComingSoonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}