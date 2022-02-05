package com.ojanbelajar.obuce.data.source.remote.network

import androidx.annotation.NonNull
import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import com.ojanbelajar.obuce.data.source.remote.response.SignupResponse
import com.ojanbelajar.obuce.data.source.remote.response.UploadFoodResponse
import okhttp3.MultipartBody
import retrofit2.http.*

interface ApiService {


    @POST("auth/login")
    suspend fun login(@Body body: LoginBody): LoginResponse

    @POST("auth/register")
    suspend fun signup(@Body body: SignupBody): SignupResponse

    @GET("food?populateNutritions=true&populateIngredients=true")
    suspend fun getFood(): ListFoodResponse

    @Multipart
    @POST
    suspend fun uploadFood(
        @Url url: String,
        @Part image: MultipartBody.Part,
    ): UploadFoodResponse
}