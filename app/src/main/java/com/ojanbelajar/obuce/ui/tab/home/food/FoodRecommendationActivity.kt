package com.ojanbelajar.obuce.ui.tab.home.food

import android.annotation.SuppressLint
import android.app.ActionBar
import android.os.Bundle
import android.view.Gravity
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityFoodRecommendationBinding
import android.R
import com.ojanbelajar.obuce.ui.tab.home.food.scan.HowToScanActivity
import com.synnapps.carouselview.ImageListener
import org.jetbrains.anko.startActivity


class FoodRecommendationActivity: AppCompatActivity() {

    var sampleImages = intArrayOf(
        R.color.black,
        R.color.darker_gray,
        R.color.holo_blue_bright,
    )

    lateinit var binding: ActivityFoodRecommendationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodRecommendationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.carouselView.pageCount = sampleImages.size
        binding.carouselView.setImageListener(imageListener)
        binding.listFood.setOnClickListener {
            startActivity<ListFoodActivity>()
        }
        binding.scanFood.setOnClickListener {
            startActivity<HowToScanActivity>()
        }
    }

    var imageListener = ImageListener { position, imageView -> imageView.setImageResource(sampleImages[position]) }

}