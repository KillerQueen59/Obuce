package com.ojanbelajar.obuce.ui.tab.home.food

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ojanbelajar.obuce.databinding.ItemIngredientBinding

class IngredientAdapter  : RecyclerView.Adapter<IngredientAdapterViewHolder>(){
        private var listData = ArrayList<String>()

        fun setData(newListData: List<String>?) {
            if (newListData == null) return
            listData.clear()
            listData.addAll(newListData)
            notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IngredientAdapterViewHolder =
            IngredientAdapterViewHolder(ItemIngredientBinding.inflate(LayoutInflater.from(parent.context),parent,false))

        override fun onBindViewHolder(holder: IngredientAdapterViewHolder, position: Int) {
            val ingredient = listData[position]
            holder.bind(ingredient)

        }

        override fun getItemCount(): Int {
            return listData.size
        }

    }

    class IngredientAdapterViewHolder(private val binding: ItemIngredientBinding): RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(ingredient: String){
            binding.ingredient.text = ingredient
        }

    }