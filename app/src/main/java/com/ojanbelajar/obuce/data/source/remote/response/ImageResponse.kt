package com.ojanbelajar.obuce.data.source.remote.response

data class ImageResponse(
    val filename: String,
    val userId: String,
    val labels: List<String>,
    val _id: String
)
