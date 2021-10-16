package com.ojanbelajar.obuce.data.source.local.viewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity
import com.ojanbelajar.obuce.data.source.local.repo.repo.HistoryRepository
import kotlinx.coroutines.launch

class HistoryViewModel(private val repository: HistoryRepository):ViewModel() {

    val inputName = MutableLiveData<String>()
    val inputtime = MutableLiveData<String>()
    val inputday = MutableLiveData<String>()
    val inputcalori = MutableLiveData<String>()
    val inputcomposition = MutableLiveData<String>()
    val inputimage = MutableLiveData<String>()

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