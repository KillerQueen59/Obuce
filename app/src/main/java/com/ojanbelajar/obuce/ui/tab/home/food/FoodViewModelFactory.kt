package com.ojanbelajar.obuce.ui.tab.home.food

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class FoodViewModelFactory(private val repository: FoodRecommendRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      /*  if(modelClass.isAssignableFrom(HistoryViewModel::class.java)){
            return FoodViewModel(repository) as T
        }*/
        throw IllegalArgumentException("Unknown View Model class")
    }


}