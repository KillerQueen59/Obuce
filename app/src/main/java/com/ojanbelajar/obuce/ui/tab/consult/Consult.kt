package com.ojanbelajar.obuce.ui.tab.consult

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Consult(
    var name: String,
    var company: String,
    var image: Int
):Parcelable
