package com.ojanbelajar.obuce.data.source.remote

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.network.ApiResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataInterface {

    suspend fun login(body: LoginBody): Flow<ApiResponse<LoginResponse>>
}