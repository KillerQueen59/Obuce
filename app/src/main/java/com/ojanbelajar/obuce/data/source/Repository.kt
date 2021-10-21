package com.ojanbelajar.obuce.data.source

import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.response.LoginResponse
import kotlinx.coroutines.flow.Flow
import okhttp3.RequestBody

interface Repository {

    fun login(body: LoginBody): Flow<Resource<LoginResponse>>

}