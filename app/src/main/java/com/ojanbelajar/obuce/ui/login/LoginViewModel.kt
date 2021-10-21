package com.ojanbelajar.obuce.ui.login

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ojanbelajar.obuce.data.source.Repository
import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import okhttp3.RequestBody

class LoginViewModel @ViewModelInject constructor(
    private val contentRepository: Repository
): ViewModel(){
    fun login(body: LoginBody) = contentRepository.login(body).asLiveData()

}