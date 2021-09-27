package com.ojanbelajar.obuce.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WorkoutEntity(
    var title: String,
    var time: String,
    var image: Int
):Parcelable
