package com.ojanbelajar.obuce.ui.tab.home.food

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ojanbelajar.obuce.data.source.Repository

class FoodViewModel @ViewModelInject constructor(
    private val contentRepository: Repository
): ViewModel() {
    fun getFood() = contentRepository.getFood().asLiveData()
}