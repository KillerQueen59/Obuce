package com.ojanbelajar.obuce.data.source.remote.response

import java.util.*

data class SignupResponse(
    val name: String,
    val email: String,
    val password: String,
    val gender: String,
    val birthdate: Date,
    val weight: Double,
    val height: Double,
    val bmi: Double,
    val _id: String,
    val __v: Int
)
