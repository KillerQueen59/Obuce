package com.ojanbelajar.obuce.ui.tab.home.food

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.FoodEntity
import com.ojanbelajar.obuce.databinding.ItemFoodBinding
import org.jetbrains.anko.startActivity


class ListFoodAdapter (private val context: Context, private val listFood: ArrayList<FoodEntity>) :
    RecyclerView.Adapter<ListFoodAdapterViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFoodAdapterViewHolder =
        ListFoodAdapterViewHolder(ItemFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ListFoodAdapterViewHolder, position: Int) {
        val food = listFood[position]
        holder.bind(food,context)
        holder.itemView.setOnClickListener {
            context.startActivity<DetailFoodActivity>()
        }
    }

    override fun getItemCount(): Int {
        return listFood.size
    }

}

class ListFoodAdapterViewHolder(private val binding: ItemFoodBinding): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(food: FoodEntity, context: Context){
        Glide.with(context).load(food.frontImage).error(R.drawable.male).into(binding.imageFood)
        binding.titleFood.text = food.title
        binding.caloriesFood.text = food.calories
        binding.priceFood.text = food.price
    }

}