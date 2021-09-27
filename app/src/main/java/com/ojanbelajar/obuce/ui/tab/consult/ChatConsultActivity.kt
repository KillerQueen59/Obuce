package com.ojanbelajar.obuce.ui.tab.consult

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ActivityChatConsultBinding
import org.jetbrains.anko.startActivity

class ChatConsultActivity : AppCompatActivity() {
    lateinit var binding:ActivityChatConsultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatConsultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivsendchatconsult.setOnClickListener {
            startActivity<ConsultAddressActivity>()
        }
    }
}