package com.ojanbelajar.obuce.data.source

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface Repository {
    fun login(body: LoginBody): Flow<Resource<LoginResponse>>
    fun getFood(): Flow<Resource<ListFoodResponse>>
}