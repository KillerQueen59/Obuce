package com.ojanbelajar.obuce.ui.login

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ojanbelajar.obuce.data.source.Resource
import com.ojanbelajar.obuce.data.source.local.entity.UserEntity
import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.databinding.ActivityLoginBinding
import com.ojanbelajar.obuce.ui.MainActivity
import com.ojanbelajar.obuce.ui.getstarted.GetStartedActivity
import com.ojanbelajar.obuce.utils.SessionManagement
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.alert
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton

@AndroidEntryPoint
class LoginActivity: AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private var loginReady = true
    lateinit var session: SessionManagement
    lateinit var model : LoginViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManagement(this)
        if (session.isLoggedIn) toMain()

        model =  ViewModelProvider(this).get(LoginViewModel::class.java)


        binding.txtSignUp.setOnClickListener {
            startActivity<GetStartedActivity>()
        }
        binding.btnSign.setOnClickListener{
            prepareLogin()
        }
    }


    fun prepareLogin(){
        if (binding.edtEmail.text.isNullOrEmpty()){
            binding.edtEmail.error = "Isikan email terlebih dahulu"
            loginReady = false
        } else if (binding.edtPassword.text.isNullOrEmpty()){
            binding.edtPassword.error = "Isikan password terlebih dahulu"
            loginReady = false
        } else if (binding.edtPassword.text.toString().length < 7) {
            binding.edtPassword.error = "Password harus lebih dari 7 karakter"
            loginReady = false
        } else {
            loginReady = true
        }

        if (loginReady){
            val body = LoginBody(binding.edtEmail.text.toString(), binding.edtPassword.text.toString())

            model.login(body).observe(this,{ result ->
                if (result != null){
                    when(result){
                        is Resource.Loading ->{
                            binding.progress.visibility = View.VISIBLE

                        }
                        is Resource.Success -> {
                            val user = UserEntity(id=0, name="test",binding.edtEmail.toString(), "",0,0.0,0.0);
                            session.createLoginSession(user)
                            toMain()
                            binding.progress.visibility = View.GONE
                        }
                        is Resource.Error -> {
                            binding.progress.visibility = View.GONE
                            alert(result.message.toString()) {
                                yesButton {}
                            }.show()
                        }
                    }
                }

            })
        }
    }

    private fun toMain() {
        startActivity<MainActivity>()
        session.createOnBoardSession()
        finish()
    }
}