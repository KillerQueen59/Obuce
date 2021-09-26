package com.ojanbelajar.obuce.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ExerciseMethodEntity (
    var title: String = "",
    var calories: String = "",
    var background: Int = 0,
    var exercises: ArrayList<ExerciseEntity> = arrayListOf()
    ): Parcelable