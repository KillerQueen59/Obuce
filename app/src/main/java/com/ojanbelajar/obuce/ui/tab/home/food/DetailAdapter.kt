package com.ojanbelajar.obuce.ui.tab.home.food

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ojanbelajar.obuce.data.source.local.entity.NutritionEntity
import com.ojanbelajar.obuce.databinding.ItemNutritionDailyValueBinding

class DetailAdapter  :
    RecyclerView.Adapter<DetailAdapterViewHolder>(){
        private var listData = ArrayList<NutritionEntity>()

        fun setData(newListData: List<NutritionEntity>?) {
            if (newListData == null) return
            listData.clear()
            listData.addAll(newListData)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailAdapterViewHolder =
            DetailAdapterViewHolder(ItemNutritionDailyValueBinding.inflate(LayoutInflater.from(parent.context),parent,false))

        override fun onBindViewHolder(holder: DetailAdapterViewHolder, position: Int) {
            val nutrition = listData[position]
            holder.bind(nutrition)

        }

        override fun getItemCount(): Int {
            return listData.size
        }

    }

    class DetailAdapterViewHolder(private val binding: ItemNutritionDailyValueBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(nutrition: NutritionEntity){
            binding.nutritionName.text = nutrition.name
            binding.nutritionMass.text = nutrition.percentage.toString()
        }

    }