package com.ojanbelajar.obuce.ui.tab.home.food.scan

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ojanbelajar.obuce.data.source.Repository
import okhttp3.MultipartBody

class HowToScanViewModel@ViewModelInject constructor(
    private val contentRepository: Repository
): ViewModel() {
    private val howTo = arrayOf(
        "Dummy1",
        "Dummy2",
        "Dummy3",
        "Dummy4",
        "Dummy5")

    val steps: ArrayList<String>
        get() {
            val list = arrayListOf<String>()
            for (position in howTo.indices) {
                val hero = howTo[position]
                list.add(hero)
            }
            return list
        }
    fun uploadFood(body: MultipartBody.Part, token: String) = contentRepository.uploadFood(body,token).asLiveData()

}