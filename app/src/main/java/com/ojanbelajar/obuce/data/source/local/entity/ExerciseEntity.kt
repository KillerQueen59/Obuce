package com.ojanbelajar.obuce.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ExerciseEntity (
    val title: String,
    val time: String,
    val image: String
    ): Parcelable