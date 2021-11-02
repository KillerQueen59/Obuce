package com.ojanbelajar.obuce.ui.tab.statistic.tab.history.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity
import com.ojanbelajar.obuce.ui.tab.statistic.tab.history.repo.HistoryRepository
import kotlinx.coroutines.launch

class HistoryViewModel(private val repository: HistoryRepository):ViewModel() {

    val inputName = MutableLiveData<String>()
    val inputtime = MutableLiveData<String>()
    val inputday = MutableLiveData<String>()
    val inputcalori = MutableLiveData<String>()
    val inputcomposition = MutableLiveData<String>()
    val inputimage = MutableLiveData<String>()

    init {
        insert(HistoryEntity(0,"rice", "00.10","Monday","125kcal","co2,co,etc",0))
        insert(HistoryEntity(1,"fat", "00.59","Monday","125kcal","co2,co,etc",0))

    }

    private fun insert(historyEntity: HistoryEntity){
        viewModelScope.launch {
            repository.insert(historyEntity)
        }
    }
    private fun initNullInsert(){

    }
    fun saveOrUpdate(){
        val name = inputName.value!!
        val time = inputtime.value!!
        val day = inputday.value!!
        val calori = inputcalori.value!!
        val composition = inputcomposition.value!!
        insert(HistoryEntity(0,name,time,day,calori,composition,0))
        inputName.value = ""
        inputtime.value = ""
        inputday.value = ""
        inputcalori.value = ""
        inputcomposition.value = ""


    }
    val subs = repository.subscribers

}