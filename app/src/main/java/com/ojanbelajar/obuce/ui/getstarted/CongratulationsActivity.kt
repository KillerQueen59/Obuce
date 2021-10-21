package com.ojanbelajar.obuce.ui.getstarted

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityCongratulationBinding
import com.ojanbelajar.obuce.ui.MainActivity
import com.ojanbelajar.obuce.ui.login.LoginActivity
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity

class CongratulationsActivity: AppCompatActivity() {


    lateinit var binding: ActivityCongratulationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationBinding.inflate(layoutInflater)
        setContentView(binding.root);

        binding.btnContinue.setOnClickListener {
            startActivity(intentFor<LoginActivity>().clearTask().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK))        }
    }


}