package com.ojanbelajar.obuce.ui.tab.home.workout

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ojanbelajar.obuce.data.source.local.entity.ExerciseMethodEntity
import com.ojanbelajar.obuce.databinding.ItemExcerciseBinding
import org.jetbrains.anko.startActivity

class ExerciseAdapter (private val context: Context, private val listExercise: ArrayList<ExerciseMethodEntity>) :
    RecyclerView.Adapter<ExerciseAdapterViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExerciseAdapterViewHolder =
        ExerciseAdapterViewHolder(ItemExcerciseBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ExerciseAdapterViewHolder, position: Int) {
        val exercise = listExercise[position]
        holder.bind(exercise,context)
        holder.itemView.setOnClickListener {
            context.startActivity<ListWorkoutActivity>("exercise" to exercise)
        }
    }

    override fun getItemCount(): Int {
        return listExercise.size
    }

}

class ExerciseAdapterViewHolder(private val binding: ItemExcerciseBinding): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(exercise: ExerciseMethodEntity, context: Context){
        binding.title.text = exercise.title
        binding.calories.text = exercise.calories
        Glide.with(context).load(exercise.background).into(binding.image)

    }

}
