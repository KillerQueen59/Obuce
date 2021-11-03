package com.ojanbelajar.obuce.ui.getstarted

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.ojanbelajar.obuce.data.source.Repository
import com.ojanbelajar.obuce.data.source.local.entity.UserEntity
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody

class SignUpViewModel @ViewModelInject constructor(
    private val contentRepository: Repository
) : ViewModel() {

    private val signUpData = MutableLiveData<UserEntity>()
    init {
        val newValue = UserEntity()
        signUpData.postValue(newValue)
    }

    fun getData(): LiveData<UserEntity> {
        return signUpData
    }
    fun getFixData(): UserEntity? {
        return signUpData.value
    }
    fun editData(newData: UserEntity) {
        signUpData.postValue(newData)
    }

    fun signup(body: SignupBody) = contentRepository.signup(body).asLiveData()
}