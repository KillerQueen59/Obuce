package com.ojanbelajar.obuce.ui.tab.home.food

import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.FoodEntity
import com.ojanbelajar.obuce.databinding.ActivityListFoodBinding

class ListFoodActivity: AppCompatActivity() {

    lateinit var binding: ActivityListFoodBinding
    lateinit var adapter: ListFoodAdapter
    private var data = ArrayList<FoodEntity>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)
        data.add(FoodEntity(0,"Salmon","","120Kcal","Rp.50.000"))
        data.add(FoodEntity(1,"Salmon","","120Kcal","Rp.50.000"))
        data.add(FoodEntity(2,"Salmon","","120Kcal","Rp.50.000"))
        data.add(FoodEntity(3,"Salmon","","120Kcal","Rp.50.000"))
        data.add(FoodEntity(4,"Salmon","","120Kcal","Rp.50.000"))
        data.add(FoodEntity(5,"Salmon","","120Kcal","Rp.50.000"))
        adapter = ListFoodAdapter(this,data)
        binding.back.setOnClickListener {
            finish()
        }
        setSpinner()
        setRv()
    }

    fun setRv(){
        binding.rvFood.layoutManager = GridLayoutManager(this,3)
        binding.rvFood.adapter = adapter
    }

    fun setSpinner(){
        val itemSort = resources.getStringArray(R.array.sortFood)
        val adapterSort = ArrayAdapter(this, R.layout.spinner_item, itemSort)
        binding.spinnerSort.adapter = adapterSort
    }
}