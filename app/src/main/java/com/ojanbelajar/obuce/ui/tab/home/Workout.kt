package com.ojanbelajar.obuce.ui.tab.home

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Workout(
    var title: String,
    var time: String,
    var image: Int
):Parcelable
