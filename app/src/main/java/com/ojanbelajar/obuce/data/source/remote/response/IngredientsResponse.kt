package com.ojanbelajar.obuce.data.source.remote.response

import com.ojanbelajar.obuce.data.source.local.entity.IngredientEntity

data class IngredientsResponse(
    val ingredient: IngredientEntity,
    val quantity: Int,
    val _id: String
)
