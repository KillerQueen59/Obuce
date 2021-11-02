package com.ojanbelajar.obuce.data.source

import com.ojanbelajar.obuce.data.source.remote.RemoteDataInterface
import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody
import com.ojanbelajar.obuce.data.source.remote.network.ApiResponse
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import com.ojanbelajar.obuce.data.source.remote.response.SignupResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class ObuceRepository @Inject constructor(
    private val contentRemoteSource: RemoteDataInterface,

    ): Repository {
    override fun login(body: LoginBody): Flow<Resource<LoginResponse>> =
        object : NetworkOnlyResource<LoginResponse,LoginResponse>(){
            override fun loadFromNetwork(data: LoginResponse): Flow<LoginResponse> {
                return flowOf(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<LoginResponse>> {
                return contentRemoteSource.login(body)
            }

        }.asFlow()

    override fun signup(body: SignupBody): Flow<Resource<SignupResponse>> =
        object : NetworkOnlyResource<SignupResponse,SignupResponse>() {
            override fun loadFromNetwork(data: SignupResponse): Flow<SignupResponse> {
                return flowOf(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<SignupResponse>> {
                return contentRemoteSource.signup(body)
            }

        }.asFlow()

    override fun getFood(): Flow<Resource<ListFoodResponse>> =
        object : NetworkOnlyResource<ListFoodResponse,ListFoodResponse>(){
            override fun loadFromNetwork(data: ListFoodResponse): Flow<ListFoodResponse> {
                return flowOf(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<ListFoodResponse>> {
                return contentRemoteSource.getFood()
            }

        }.asFlow()
}