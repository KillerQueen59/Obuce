package com.ojanbelajar.obuce.data.source.remote

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody
import com.ojanbelajar.obuce.data.source.remote.network.ApiResponse
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import com.ojanbelajar.obuce.data.source.remote.response.SignupResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataInterface {

    suspend fun login(body: LoginBody): Flow<ApiResponse<LoginResponse>>

    suspend fun signup(body: SignupBody): Flow<ApiResponse<SignupResponse>>

    suspend fun getFood(): Flow<ApiResponse<ListFoodResponse>>
}