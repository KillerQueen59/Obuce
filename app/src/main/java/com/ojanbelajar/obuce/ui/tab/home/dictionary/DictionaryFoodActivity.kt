package com.ojanbelajar.obuce.ui.tab.home.dictionary

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.databinding.ActivityDictionaryFoodBinding

class DictionaryFoodActivity: AppCompatActivity() {

    lateinit var binding: ActivityDictionaryFoodBinding
    lateinit var viewModel: DictionaryFoodViewModel
    lateinit var adapter: DictionaryFoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDictionaryFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =  ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DictionaryFoodViewModel::class.java)

        adapter = DictionaryFoodAdapter(viewModel.data, this)

        binding.back.setOnClickListener {
            finish()
        }

        setRv()
    }

    fun setRv(){
        binding.rvDictionary.layoutManager = LinearLayoutManager(this)
        binding.rvDictionary.adapter = adapter
    }
}