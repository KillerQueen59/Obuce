package com.ojanbelajar.obuce.utils

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.ojanbelajar.obuce.data.source.local.entity.UserEntity
import com.ojanbelajar.obuce.ui.login.LoginActivity

class SessionManagement(var context: Context) {
    companion object{
        private val PREF_NAME = "arontaapps"
        private val IS_LOGIN = "IsLoggedIn"
        private val IS_FIRST = "isFirstOpen"

        //farmer
        val KEY_ID = "id"
        val KEY_NAME = "name"
        val KEY_EMAIL = "email"
        val KEY_GENDER = "gender"
        val KEY_WEIGHT = "weight"
        val KEY_HEIGHT = "height"
        val KEY_TOKEN = "token"
    }

    var pref: SharedPreferences
    var editor: SharedPreferences.Editor
    var PRIVATE_MODE = 0

    init {
        pref = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE)
        editor = pref.edit()
    }

    val token: String
        get() {
            return pref.getString(KEY_TOKEN,"").toString()
        }

    val user: HashMap<String,String>
        get() {
            val  user = HashMap<String , String>()
            user[KEY_EMAIL] = pref.getString(KEY_EMAIL, "").toString()
            user[KEY_ID] = pref.getString(KEY_ID, "").toString()
            user[KEY_NAME] = pref.getString(KEY_NAME, "").toString()
            user[KEY_GENDER] = pref.getString(KEY_GENDER, "").toString()
            user[KEY_WEIGHT] = pref.getString(KEY_WEIGHT, "").toString()
            user[KEY_HEIGHT] = pref.getString(KEY_HEIGHT, "").toString()
            return user
        }

    val isLoggedIn: Boolean
        get() = pref.getBoolean(IS_LOGIN, false)
    val isFirstOpen: Boolean
        get() = pref.getBoolean(IS_FIRST, false)

    fun createLoginSession(user: UserEntity){
        editor.putBoolean(IS_LOGIN,true)
        editor.putInt(KEY_ID, user.id)
        editor.putString(KEY_EMAIL, user.email)
        editor.putString(KEY_NAME, user.name)
        editor.putInt(KEY_GENDER, user.gender)
        editor.putFloat(KEY_HEIGHT, user.height.toFloat())
        editor.putFloat(KEY_WEIGHT, user.weight.toFloat())
        editor.commit()
    }

    fun updateTokenSession(token: String){
        editor.putString(KEY_TOKEN,token)
        editor.commit()
    }

    fun checkLogin(): Boolean = this.isLoggedIn
    fun checkFirst(): Boolean = this.isFirstOpen

    fun logoutUser() {
        editor.remove(IS_LOGIN)

        editor.remove(KEY_ID)
        editor.remove(KEY_EMAIL)
        editor.remove(KEY_NAME)
        editor.remove(KEY_GENDER)
        editor.remove(KEY_HEIGHT)
        editor.remove(KEY_WEIGHT)
        editor.remove(KEY_TOKEN)
        editor.commit()

        val intent = Intent(context, LoginActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        context.startActivity(intent)

    }

    fun createOnBoardSession() {
        editor.putBoolean(IS_FIRST,true)
        editor.commit()
    }
}