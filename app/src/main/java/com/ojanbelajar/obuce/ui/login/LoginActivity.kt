package com.ojanbelajar.obuce.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.data.source.local.entity.UserEntity
import com.ojanbelajar.obuce.databinding.ActivityLoginBinding
import com.ojanbelajar.obuce.ui.MainActivity
import com.ojanbelajar.obuce.ui.getstarted.GetStartedActivity
import com.ojanbelajar.obuce.utils.SessionManagement
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class LoginActivity: AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private var loginReady = true
    lateinit var session: SessionManagement
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManagement(this)
        if (session.isLoggedIn) toMain()
        binding.txtSignUp.setOnClickListener {
            startActivity<GetStartedActivity>()
        }
        binding.btnSign.setOnClickListener{
            if (binding.edtEmail.text.isNullOrEmpty()){
                binding.edtEmail.error = "Isikan email terlebih dahulu"
                loginReady = false
            } else if (binding.edtPassword.text.isNullOrEmpty()){
                binding.edtPassword.error = "Isikan password terlebih dahulu"
                loginReady = false
            }
            if (loginReady){
                toast("masuk")
                val user = UserEntity(0,"test",binding.edtEmail.toString(),0,0.0,0.0);
                session.createLoginSession(user)
                toMain()
            }

        }
    }

    private fun toMain() {
        startActivity<MainActivity>()
        session.createOnBoardSession()
        finish()
    }
}