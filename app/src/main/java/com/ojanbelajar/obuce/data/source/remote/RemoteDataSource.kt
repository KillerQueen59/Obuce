package com.ojanbelajar.obuce.data.source.remote

import android.util.Log
import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody
import com.ojanbelajar.obuce.data.source.remote.network.ApiResponse
import com.ojanbelajar.obuce.data.source.remote.network.ApiService
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import com.ojanbelajar.obuce.data.source.remote.response.SignupResponse
import com.ojanbelajar.obuce.data.source.remote.response.UploadFoodResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.MultipartBody
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

    override suspend fun signup(body: SignupBody): Flow<ApiResponse<SignupResponse>> {
        return flow {
            try {
                val response = apiService.signup(body)
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

    override suspend fun getFood(): Flow<ApiResponse<ListFoodResponse>> {
        return flow {
            try {
                val response = apiService.getFood()
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

    override suspend fun uploadFood(body: MultipartBody.Part,token: String): Flow<ApiResponse<UploadFoodResponse>> {
        return flow {
            try {
                val response = apiService.uploadFood("http://34.124.236.36:3000/v1/food/upload",body )
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