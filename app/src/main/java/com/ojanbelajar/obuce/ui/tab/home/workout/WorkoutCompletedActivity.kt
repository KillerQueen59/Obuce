package com.ojanbelajar.obuce.ui.tab.home.workout

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityWorkoutCompletedBinding
import com.ojanbelajar.obuce.ui.MainActivity
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor

class WorkoutCompletedActivity : AppCompatActivity() {

    lateinit var binding: ActivityWorkoutCompletedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutCompletedBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.finishBtn.setOnClickListener {
            startActivity(intentFor<MainActivity>().clearTask().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }
}