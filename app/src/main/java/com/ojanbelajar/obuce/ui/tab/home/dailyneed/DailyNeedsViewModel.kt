package com.ojanbelajar.obuce.ui.tab.home.dailyneed

import androidx.lifecycle.ViewModel
import com.ojanbelajar.obuce.data.source.local.entity.DailyNutritionEntity

class DailyNeedsViewModel: ViewModel() {
    val dailyNeedsList: ArrayList<DailyNutritionEntity>
        get() {
            val list= arrayListOf<DailyNutritionEntity>()
            for (position in nameDummy.indices){
                val item = DailyNutritionEntity(name = nameDummy[position],
                    amount = amount[position],
                    type = type[position]
                )
                list.add(item)
            }
            return list
        }

    // START - Generate Dummy Data
    private val nameDummy = arrayOf(
        "Energi",
        "Protein",
        "Lemak",
        "Karbohidrat",
        "testtesttest"
    )
    private val amount = arrayOf(
        2000,
        400,
        300,
        700,
        999
    )
    private val type = arrayOf(
        "Kcal",
        "Gram",
        "Gram",
        "Gram",
        "Kilo"
    )
    // END - Generate Dummy Data
}