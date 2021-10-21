package com.ojanbelajar.obuce.data.source.remote

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.network.ApiResponse
import com.ojanbelajar.obuce.data.source.remote.network.ApiService
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService): RemoteDataInterface {

    override suspend fun login(body: LoginBody): Flow<ApiResponse<LoginResponse>> {
        return flow {
            try {
                val response = apiService.login(body)
                if (!response.equals(null)) {
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO )
    }
}