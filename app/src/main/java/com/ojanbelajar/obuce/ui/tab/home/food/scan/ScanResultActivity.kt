package com.ojanbelajar.obuce.ui.tab.home.food.scan

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.databinding.ActivityScanResultBinding
import kotlinx.android.synthetic.main.activity_scan_result.*

class ScanResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityScanResultBinding
    private lateinit var viewModel: ScanResultViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScanResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(ScanResultViewModel::class.java)

        showFoodInformation()
    }

    private fun showFoodInformation(){
        binding.foodCalories.text = viewModel.foodCalories.toString()
        showRvNutritionFacts()
        showRvIngredients()
        showRvCookingSteps()
    }

    private fun showRvNutritionFacts() {
        rv_nutritionFacts.layoutManager = GridLayoutManager(this, viewModel.listNutritions.size)
        val nutritionsFactsAdapter = NutritionsFactsAdapter(viewModel.listNutritions)
        rv_nutritionFacts.adapter = nutritionsFactsAdapter

        Log.d("ScanResultActivity", "show RV NutritionsFacts")

        nutritionsFactsAdapter.setOnItemClickCallback(object: NutritionsFactsAdapter.OnItemClickCallback{
            override fun onItemClicked(data: NutritionValue){
            }
        })
    }

    private fun showRvIngredients() {
        rv_foodIngredients.layoutManager = LinearLayoutManager(this)
        val listSimpleItemAdapter = ListSimpleItemAdapter(viewModel.listIngredient)
        rv_foodIngredients.adapter = listSimpleItemAdapter

        listSimpleItemAdapter.setOnItemClickCallback(object: ListSimpleItemAdapter.OnItemClickCallback{
            override fun onItemClicked(data: String) {
            }
        })
    }

    private fun showRvCookingSteps() {
        rv_foodCookingSteps.layoutManager = LinearLayoutManager(this)
        val listSimpleItemAdapter = ListSimpleItemAdapter(viewModel.listCookingStep)
        rv_foodCookingSteps.adapter = listSimpleItemAdapter

        listSimpleItemAdapter.setOnItemClickCallback(object: ListSimpleItemAdapter.OnItemClickCallback{
            override fun onItemClicked(data: String) {
            }
        })
    }
}