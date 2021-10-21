package com.ojanbelajar.obuce.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history_data_table")
data class HistoryEntity(

    @PrimaryKey()
    @ColumnInfo(name = "id")
    var id: Int,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "time")
    var time: String,

    @ColumnInfo(name = "day")
    var day: String,

    @ColumnInfo(name = "calori")
    var calori: String,

    @ColumnInfo(name = "composition")
    var composition: String,

    @ColumnInfo(name = "image")
    var image: Int
    )

//
//@Parcelize
//data class HistoryEntity(
//    var name: String,
//    var time: String,
//    var day: String,
//    var calori: String,
//    var composition: String,
//    var image: Int
//): Parcelable
