package com.ojanbelajar.obuce.ui.login

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityLoginBinding
import com.ojanbelajar.obuce.ui.MainActivity
import com.ojanbelajar.obuce.ui.getstarted.GetStartedActivity
import org.jetbrains.anko.startActivity

class LoginActivity: AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    private var loginReady = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
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

                startActivity<MainActivity>()
            }

        }
    }
}