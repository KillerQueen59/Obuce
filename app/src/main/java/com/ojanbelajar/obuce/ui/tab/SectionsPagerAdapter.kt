package com.ojanbelajar.obuce.ui.tab

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ojanbelajar.obuce.ui.tab.home.HomeFragment

class SectionsPagerAdapter (activity: AppCompatActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return 1
    }

    override fun createFragment(position: Int): Fragment {
        return HomeFragment.newInstance(position+1)
    }
}