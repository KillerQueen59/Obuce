package com.ojanbelajar.obuce.data.source.remote.body

data class SignupBody (
    val name: String,
    val email: String,
    val password: String,
    val gender: String,
    val weight: Double,
    val height: Double,
    val birthdate: String
)