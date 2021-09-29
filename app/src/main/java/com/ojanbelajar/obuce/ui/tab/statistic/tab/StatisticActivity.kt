package com.ojanbelajar.obuce.ui.tab.statistic.tab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import com.ojanbelajar.obuce.databinding.ActivityStatisticBinding
import com.ojanbelajar.obuce.ui.tab.statistic.SectionsPagerAdapter

class StatisticActivity : AppCompatActivity() {
        companion object {
        private val TAB_TITLES = arrayOf(
            "Histori",
            "Data"
        )
    }
    lateinit var binding:ActivityStatisticBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityStatisticBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val sectionsPagerAdapter = SectionsPagerAdapter(this)
        binding.viewpgConsult.adapter = sectionsPagerAdapter
        val tabs = binding.tabStatistic
        val viewpg = binding.viewpgConsult

        //SAMPLE CODE to disable swiping in viewpager2
        viewpg.isUserInputEnabled = false

        //control tab management
        TabLayoutMediator(tabs,viewpg){tab,position->
            tab.text = TAB_TITLES[position]
        }.attach()


    }
}