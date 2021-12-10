package com.ojanbelajar.obuce.ui.tab.home.dailyneed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.DailyNutritionEntity
import com.ojanbelajar.obuce.databinding.ActivityDailyNeedsBinding
import com.ojanbelajar.obuce.ui.tab.home.food.scan.NutritionValue
import com.ojanbelajar.obuce.ui.tab.home.food.scan.NutritionsFactsAdapter
import com.ojanbelajar.obuce.ui.tab.home.food.scan.ScanResultViewModel
import kotlinx.android.synthetic.main.activity_daily_needs.*
import kotlinx.android.synthetic.main.activity_scan_result.*

class DailyNeedsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDailyNeedsBinding
    private lateinit var viewModel: DailyNeedsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDailyNeedsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DailyNeedsViewModel::class.java)

        //viewModel.dummyDailyNeedsListGenerate()
        showRvDailyneeds()
    }

    private fun showRvDailyneeds() {
        rv_dailyneeds.layoutManager = GridLayoutManager(this, 2)
        val dailyNeedsAdapter = DailyNeedsAdapter(viewModel.dailyNeedsList)
        rv_dailyneeds.adapter = dailyNeedsAdapter

        Log.d("DailyNeedsActivity", "show RV NutritionsFacts")

        dailyNeedsAdapter.setOnItemClickCallback(object: DailyNeedsAdapter.OnItemClickCallback{
            override fun onItemClicked(data: DailyNutritionEntity){
            }
        })
    }
}