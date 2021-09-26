package com.ojanbelajar.obuce.ui.tab.home.workout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.ExerciseMethodEntity
import com.ojanbelajar.obuce.databinding.ActivityWorkoutMethodeBinding
import org.jetbrains.anko.startActivity

class WorkoutMethodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWorkoutMethodeBinding
    private var listData = ArrayList<ExerciseMethodEntity>()
    lateinit var adapter: ExerciseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutMethodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        listData.add(ExerciseMethodEntity("UpperBody","300 KCal", R.drawable.thumbnailworkoutone))
        listData.add(ExerciseMethodEntity("UpperBody","300 KCal", R.drawable.thumbnailworkouttwo))
        adapter = ExerciseAdapter(this,listData)
        binding.rvExercise.layoutManager = LinearLayoutManager(this)
        binding.rvExercise.adapter = adapter
    }
}