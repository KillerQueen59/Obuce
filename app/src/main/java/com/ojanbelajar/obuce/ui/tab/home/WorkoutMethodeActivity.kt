package com.ojanbelajar.obuce.ui.tab.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityWorkoutMethodeBinding
import org.jetbrains.anko.startActivity

class WorkoutMethodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWorkoutMethodeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutMethodeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.cvWorkoutone.setOnClickListener {
            startActivity<ListWorkoutActivity>()
        }
        binding.cvWorkouttwo.setOnClickListener {
            startActivity<ListWorkoutActivity>()
        }
    }
}