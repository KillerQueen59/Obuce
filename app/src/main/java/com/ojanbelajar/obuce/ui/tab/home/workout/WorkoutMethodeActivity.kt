package com.ojanbelajar.obuce.ui.tab.home.workout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.ExerciseEntity
import com.ojanbelajar.obuce.data.source.local.entity.ExerciseMethodEntity
import com.ojanbelajar.obuce.databinding.ActivityWorkoutMethodeBinding

class WorkoutMethodeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWorkoutMethodeBinding
    private var listData = ArrayList<ExerciseMethodEntity>()
    lateinit var adapter: ExerciseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWorkoutMethodeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var listExercise = ArrayList<ExerciseEntity>()
        listExercise.add(ExerciseEntity("SQUAT","10.00",""))
        listExercise.add(ExerciseEntity("Push Up","10.00 ",""))
        listExercise.add(ExerciseEntity("Sit Up","10.00 ",""))
        listExercise.add(ExerciseEntity("Aktivitas Rumah ","60.00",""))
        listData.add(ExerciseMethodEntity("Normal","Turun 0,5 - 1 Kg/minggu", R.drawable.thumbnailworkoutone,listExercise))
        listExercise.clear()
        listExercise.add(ExerciseEntity("Bersepeda ","5",""))
        listExercise.add(ExerciseEntity("TABATA","20.00",""))
        listExercise.add(ExerciseEntity("Senam Aerobik","30.00",""))
        listData.add(ExerciseMethodEntity("Cepat","Turun 0,5 kg/ 3 hari", R.drawable.thumbnailworkouttwo,listExercise))
        listExercise.clear()
        listExercise.add(ExerciseEntity("SQUAT","10.00",""))
        listExercise.add(ExerciseEntity("Jogging","30.00",""))
        listData.add(ExerciseMethodEntity("Lambat","Turun 0,5 – 1 kg/ bulan", R.drawable.thumbnailworkouttwo,listExercise))
        adapter = ExerciseAdapter(this,listData)
        binding.rvExercise.layoutManager = LinearLayoutManager(this)
        binding.rvExercise.adapter = adapter


    }
}