package com.ojanbelajar.obuce.ui.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityLoginBinding
import com.ojanbelajar.obuce.ui.getstarted.GetStartedActivity
import org.jetbrains.anko.startActivity

class LoginActivity: AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.txtSignUp.setOnClickListener {
            startActivity<GetStartedActivity>()
        }
    }
}