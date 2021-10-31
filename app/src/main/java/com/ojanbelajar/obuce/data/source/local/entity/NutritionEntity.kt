package com.ojanbelajar.obuce.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class NutritionEntity(
    var name: String = "",
    val percentage: Double
): Parcelable
