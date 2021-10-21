package com.ojanbelajar.obuce.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.ojanbelajar.obuce.data.source.local.entity.NutritionEntity

class Converters {
    @TypeConverter
    fun listToJson(value: List<String>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToList(value: String) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun listToJsonNutrition(value: List<NutritionEntity>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListNutrition(value: String) = Gson().fromJson(value, Array<NutritionEntity>::class.java).toList()
}