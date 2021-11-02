package com.ojanbelajar.obuce.data.source.remote.response

import com.ojanbelajar.obuce.data.source.local.entity.NutritionEntity

data class NutritionsResponse(
    val nutrition: NutritionEntity,
    val quantity: Int,
    val _id: String
)