package com.ojanbelajar.obuce.ui.tab.consult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ActivityConsultAddressBinding

class ConsultAddressActivity : AppCompatActivity() {

    lateinit var binding: ActivityConsultAddressBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultAddressBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}