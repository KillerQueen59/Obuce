package com.ojanbelajar.obuce.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "food_recommend_data_table")
@Parcelize
data class FoodEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = "",

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
    var nutrition: List<NutritionEntity> = arrayListOf(),

    @ColumnInfo(name = "ingredient")
    var ingredient: List<String> = arrayListOf(),

    @ColumnInfo(name = "step")
    var step: List<String> = arrayListOf()
): Parcelable
