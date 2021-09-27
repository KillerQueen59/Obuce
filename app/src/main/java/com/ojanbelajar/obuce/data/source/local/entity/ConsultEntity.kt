package com.ojanbelajar.obuce.data.source.local.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ConsultEntity(
    var name: String,
    var company: String,
    var image: Int
):Parcelable
