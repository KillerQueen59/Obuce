package com.ojanbelajar.obuce.ui.tab.statistic.tab.history.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ojanbelajar.obuce.ui.tab.statistic.tab.history.repo.HistoryRepository

class HistoryViewModelFactory(private val repository: HistoryRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(HistoryViewModel::class.java)){
            return HistoryViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown View Model class")
    }
}