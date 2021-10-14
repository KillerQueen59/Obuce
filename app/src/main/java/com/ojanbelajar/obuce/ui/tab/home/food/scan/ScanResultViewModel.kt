package com.ojanbelajar.obuce.ui.tab.home.food.scan

import android.util.Log
import androidx.lifecycle.ViewModel

class ScanResultViewModel: ViewModel() {

    var foodCalories = 150

    private var nutritionNames = arrayOf(
        "Fat",
        "Sat",
        "Car"
    )
    private var nutritionMass = arrayOf(
        6.9,
        1.0,
        2.3
    )
    private var nutritionMassUnit = arrayOf(
        "gr",
        "gr",
        "gr"
    )
    private var nutritionDailyValuePercentage = arrayOf(
        10.6,
        4.8,
        0.8
    )

    val listNutritions: ArrayList<NutritionValue>
        get() {
            Log.d("ScanResultViewModel", "getting listNutritions")
            val list = arrayListOf<NutritionValue>()
            for (position in nutritionNames.indices) {
                val nutrition = NutritionValue()
                nutrition.name = nutritionNames[position]
                nutrition.mass = nutritionMass[position]
                nutrition.unit = nutritionMassUnit[position]
                nutrition.percentage = nutritionDailyValuePercentage[position]
                list.add(nutrition)
            }
            Log.d("ScanResultViewModel", "retrieving listNutritions")
            return list
        }

    val listIngredient: ArrayList<String>
        get() {
            Log.d("ScanResultViewModel", "getting listNutritions")
            val list = arrayListOf<String>()
            for (position in nutritionNames.indices) {
                val nutrition = nutritionNames[position]
                list.add(nutrition)
            }
            Log.d("ScanResultViewModel", "retrieving listNutritions")
            return list
        }

    val listCookingStep: ArrayList<String>
        get() {
            Log.d("ScanResultViewModel", "getting listNutritions")
            val list = arrayListOf<String>()
            for (position in nutritionNames.indices) {
                val nutrition = nutritionNames[position]
                list.add(nutrition)
            }
            Log.d("ScanResultViewModel", "retrieving listNutritions")
            return list
        }

}