package com.ojanbelajar.obuce.data.source.local.entity

import java.util.*

data class UserEntity (
    var id: Int = 0,
    var name: String = "",
    var email: String = "",
    var password: String = "",
    var gender: Int = 0,
    var weight: Double = 0.0,
    var height: Double = 0.0,
    var birthdate: Date = Date(2000, 12, 30)
    )


