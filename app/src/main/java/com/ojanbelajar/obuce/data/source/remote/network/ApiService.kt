package com.ojanbelajar.obuce.data.source.remote.network

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {


    @POST("auth/login")
    suspend fun login(@Body body: LoginBody): LoginResponse

}