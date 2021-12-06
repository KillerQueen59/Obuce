package com.ojanbelajar.obuce.data.source

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody
import com.ojanbelajar.obuce.data.source.remote.response.ListFoodResponse
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import com.ojanbelajar.obuce.data.source.remote.response.SignupResponse
import com.ojanbelajar.obuce.data.source.remote.response.UploadFoodResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface Repository {
    fun login(body: LoginBody): Flow<Resource<LoginResponse>>
    fun signup(body: SignupBody): Flow<Resource<SignupResponse>>
    fun getFood(): Flow<Resource<ListFoodResponse>>
    fun uploadFood(body: MultipartBody.Part, token: String): Flow<Resource<UploadFoodResponse>>
}