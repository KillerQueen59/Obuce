package com.ojanbelajar.obuce.ui.tab.consult

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityChatConsultBinding

class ChatConsultActivity : AppCompatActivity() {
    lateinit var binding:ActivityChatConsultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChatConsultBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}