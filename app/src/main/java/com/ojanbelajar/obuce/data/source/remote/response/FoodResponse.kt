package com.ojanbelajar.obuce.data.source.remote.response

data class FoodResponse(
    val _id: String,
    val name: String,
    val calories: String,
    val nutritions: ArrayList<NutritionsResponse>,
    val ingredients: ArrayList<IngredientsResponse>
)