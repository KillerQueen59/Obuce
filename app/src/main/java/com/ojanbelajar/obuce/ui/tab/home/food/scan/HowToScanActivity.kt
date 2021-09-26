package com.ojanbelajar.obuce.ui.tab.home.food.scan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ActivityHowToScanBinding
import org.jetbrains.anko.startActivity

class HowToScanActivity : AppCompatActivity() {

    lateinit var binding: ActivityHowToScanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHowToScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.scanFood.setOnClickListener{
            startActivity<ScanResultActivity>()
        }
    }
}