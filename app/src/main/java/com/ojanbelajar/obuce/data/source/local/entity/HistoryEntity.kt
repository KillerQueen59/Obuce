package com.ojanbelajar.obuce.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class HistoryEntity(
    var name: String,
    var time: String,
    var day: String,
    var calori: String,
    var composition: String,
    var image: Int
): Parcelable
