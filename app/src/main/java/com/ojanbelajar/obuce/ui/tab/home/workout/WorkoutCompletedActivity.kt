package com.ojanbelajar.obuce.ui.tab.home.workout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityWorkoutCompletedBinding

class WorkoutCompletedActivity : AppCompatActivity() {

    lateinit var binding: ActivityWorkoutCompletedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutCompletedBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}