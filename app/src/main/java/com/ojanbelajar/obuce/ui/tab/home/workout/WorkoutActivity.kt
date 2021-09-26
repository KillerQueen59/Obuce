package com.ojanbelajar.obuce.ui.tab.home.workout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityWorkoutBinding
import org.jetbrains.anko.startActivity

class WorkoutActivity : AppCompatActivity() {

    lateinit var binding: ActivityWorkoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivFinished.setOnClickListener{
            startActivity<WorkoutCompletedActivity>()
        }
    }
}