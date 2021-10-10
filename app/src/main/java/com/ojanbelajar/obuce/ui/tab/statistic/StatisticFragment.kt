package com.ojanbelajar.obuce.ui.tab.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.ojanbelajar.obuce.databinding.FragmentStatisticBinding

class StatisticFragment : Fragment() {

    companion object {
        private val TAB_TITLES = arrayOf(
            "Histori",
            "Data"
        )
    }

    lateinit var binding: FragmentStatisticBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStatisticBinding.inflate(layoutInflater,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sectionsPagerAdapter = SectionsPagerAdapter(requireActivity())
        binding.viewpgConsult.adapter = sectionsPagerAdapter
        val tabs = binding.tabStatistic
        val viewpg = binding.viewpgConsult

        //SAMPLE CODE to disable swiping in viewpager2
        viewpg.isUserInputEnabled = false

        //control tab management
        TabLayoutMediator(tabs,viewpg){tab,position->
            tab.text = StatisticFragment.TAB_TITLES[position]
        }.attach()

    }
}