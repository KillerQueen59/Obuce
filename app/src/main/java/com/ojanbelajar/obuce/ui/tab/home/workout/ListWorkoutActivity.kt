package com.ojanbelajar.obuce.ui.tab.home.workout

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.ExerciseMethodEntity
import com.ojanbelajar.obuce.databinding.ActivityListWorkoutBinding

class ListWorkoutActivity : AppCompatActivity() {
    var listonboardItem = ArrayList<Workout>()

    lateinit var binding: ActivityListWorkoutBinding
    lateinit var exercise: ExerciseMethodEntity
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListWorkoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        exercise = intent.getParcelableExtra("exercise") ?: ExerciseMethodEntity()
        listonboardItem.addAll(listWorksout)
        rvsetup()
        binding.videoView.background = resources.getDrawable(exercise.background)
    }

    private fun rvsetup() {
        binding.rvListworkout.setHasFixedSize(true)
        binding.rvListworkout.layoutManager = LinearLayoutManager(this)
        val workoutadapter = WorkoutAdapter(this,listonboardItem)
        binding.rvListworkout.adapter = workoutadapter

    }
    private val listWorksout: ArrayList<Workout>
        get() {
            val datatitle = resources.getStringArray(R.array.datatitle)
            val datatime = resources.getStringArray(R.array.datatime)
            val dataPhoto = resources.obtainTypedArray(R.array.dataimage)
            val listwork = ArrayList<Workout>()
            for (i in datatitle.indices) {
                val work = Workout(datatitle[i], datatime[i], dataPhoto.getResourceId(i, 0))
                listwork.add(work)
            }

            return listwork

        }
}


