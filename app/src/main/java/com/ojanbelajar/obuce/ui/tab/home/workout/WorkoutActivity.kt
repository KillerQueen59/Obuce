package com.ojanbelajar.obuce.ui.tab.home.workout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.ojanbelajar.obuce.databinding.ActivityWorkoutBinding
import org.jetbrains.anko.startActivity


class WorkoutActivity : AppCompatActivity() {

    private var bar = 0
    lateinit var binding: ActivityWorkoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFinished.setOnClickListener{
            startActivity<WorkoutCompletedActivity>()
        }

        binding.seekBar.isEnabled = false
        checkButton(bar)
        binding.next.setOnClickListener {
            bar++
            binding.seekBar.progress = bar
            checkButton(bar)

        }
        binding.previous.setOnClickListener {
            bar--
            binding.seekBar.progress = bar
            checkButton(bar)
        }
    }

    private fun checkButton(bar: Int){
        if(bar>1){
            binding.previous.isVisible = false
            binding.next.isVisible = true
        }

    }
}