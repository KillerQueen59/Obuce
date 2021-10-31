package com.ojanbelajar.obuce.ui.tab.home.food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.data.source.local.entity.FoodEntity
import com.ojanbelajar.obuce.databinding.ActivityDetailFoodBinding

class DetailFoodActivity: AppCompatActivity() {

    lateinit var binding: ActivityDetailFoodBinding
    lateinit var data: FoodEntity
    lateinit var adapter: DetailAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = DetailAdapter()
        setupRV()
        data = intent.getParcelableExtra("food")?: FoodEntity()
        init(data)
        binding.back.setOnClickListener {
            finish()
        }
    }

    fun init(food: FoodEntity){
        binding.title.text = food.title
        binding.description.text = food.description
        binding.price.text = food.price
        binding.calories.text = food.calories
        adapter.setData(food.nutrition)
    }

    fun setupRV(){
        binding.rvNutrition.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL, false)
        binding.rvNutrition.adapter = adapter
    }

}