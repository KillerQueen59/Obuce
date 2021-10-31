package com.ojanbelajar.obuce.ui.tab.home.food

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.Resource
import com.ojanbelajar.obuce.data.source.local.entity.FoodEntity
import com.ojanbelajar.obuce.data.source.local.entity.NutritionEntity
import com.ojanbelajar.obuce.data.source.local.entity.UserEntity
import com.ojanbelajar.obuce.databinding.ActivityListFoodBinding
import com.ojanbelajar.obuce.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.alert
import org.jetbrains.anko.toast
import org.jetbrains.anko.yesButton

@AndroidEntryPoint
class ListFoodActivity: AppCompatActivity() {

    lateinit var binding: ActivityListFoodBinding
    lateinit var adapter: ListFoodAdapter
    private var data = ArrayList<FoodEntity>()
    lateinit var model : FoodViewModel



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        model =  ViewModelProvider(this).get(FoodViewModel::class.java)
        adapter = ListFoodAdapter(this)
        getFood()
        binding.back.setOnClickListener {
            finish()
        }
        setSpinner()
        setRv()
    }

    fun getFood(){
        model.getFood().observe(this,{ result ->

            if (result != null){
                when(result){
                    is Resource.Loading ->{
                        binding.progress.isVisible = true
                        binding.rvFood.isVisible = false
                    }
                    is Resource.Success -> {
                       for(f in result.data!!.foods){
                           val nutritions: ArrayList<NutritionEntity> = arrayListOf()
                           for(n in f.nutritions){
                                val nut = NutritionEntity(n.nutrition, n.quantity.toDouble())
                                nutritions.add(nut)
                           }
                           val ingredients: ArrayList<String> = arrayListOf()
                           for(i in f.ingredients){
                               val ing = i.ingredient
                               ingredients.add(ing)
                           }
                            val food = FoodEntity(f._id,f.name,"",f.calories,"","",
                                emptyList(), nutritions, ingredients, arrayListOf()
                            )
                           data.add(food)
                       }
                        binding.progress.isVisible = false
                        binding.rvFood.isVisible = true
                        adapter.setData(data)
                    }
                    is Resource.Error -> {
                        binding.progress.isVisible = false
                        binding.rvFood.isVisible = false
                        toast(result.message.toString())
                    }
                }
            }
        })
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