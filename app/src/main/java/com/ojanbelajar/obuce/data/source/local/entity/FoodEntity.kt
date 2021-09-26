package com.ojanbelajar.obuce.data.source.local.entity

data class FoodEntity(
    var title: String = "",
    var description: String = "",
    var calories: String = "",
    var price: String = "",
    var frontImage: String = "",
    var images: List<String> = emptyList(),
    var nutrition: List<NutritionEntity> = emptyList(),
    var ingredient: List<String> = emptyList(),
    var step: List<String> = emptyList()
)
