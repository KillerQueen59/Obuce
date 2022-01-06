package com.ojanbelajar.obuce.ui.tab.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ActivityDailyNeedsBinding

class DailyNeedsActivity : AppCompatActivity() {

    lateinit var binding: ActivityDailyNeedsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyNeedsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}