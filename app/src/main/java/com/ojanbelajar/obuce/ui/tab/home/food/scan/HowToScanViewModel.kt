package com.ojanbelajar.obuce.ui.tab.home.food.scan

import androidx.lifecycle.ViewModel

class HowToScanViewModel: ViewModel() {
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

}