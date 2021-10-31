package com.ojanbelajar.obuce.data.source.remote.network

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {


    @POST("auth/login")
    suspend fun login(@Body body: LoginBody): LoginResponse


    @GET("food")
    suspend fun getFood(): ListFoodResponse
}