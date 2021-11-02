package com.ojanbelajar.obuce.data.source.remote.network

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import com.ojanbelajar.obuce.data.source.remote.response.SignupResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.http.*

interface ApiService {


    @POST("auth/login")
    suspend fun login(@Body body: LoginBody): LoginResponse

    @POST("auth/register")
    suspend fun signup(@Body body: SignupBody): SignupResponse

    @GET("food?populateNutritions=true&populateIngredients=true")
    suspend fun getFood(): ListFoodResponse

    @Multipart
    @POST("food/upload")
    suspend fun uploadFood(
        @Part image:MultipartBody.Part
    )
}