package com.ojanbelajar.obuce.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "food_recommend_data_table")
data class FoodEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: Int = 0,

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "calories")
    var calories: String = "",

    @ColumnInfo(name = "price")
    var price: String = "",

    @ColumnInfo(name = "frontImage")
    var frontImage: String = "",

    @ColumnInfo(name = "images")
    var images: List<String> = emptyList(),

    @ColumnInfo(name = "nutrition")
    var nutrition: List<NutritionEntity> = emptyList(),

    @ColumnInfo(name = "ingredient")
    var ingredient: List<String> = emptyList(),

    @ColumnInfo(name = "step")
    var step: List<String> = emptyList()
)
