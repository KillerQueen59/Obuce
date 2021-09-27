package com.ojanbelajar.obuce.ui.tab.home.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityDictionaryFoodBinding

class DictionaryFoodActivity: AppCompatActivity() {

    lateinit var binding: ActivityDictionaryFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDictionaryFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}