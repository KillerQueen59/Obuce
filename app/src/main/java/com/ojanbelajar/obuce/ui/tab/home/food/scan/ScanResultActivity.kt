package com.ojanbelajar.obuce.ui.tab.home.food.scan

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ActivityScanResultBinding

class ScanResultActivity : AppCompatActivity() {

    lateinit var binding : ActivityScanResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}