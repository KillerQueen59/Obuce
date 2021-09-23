package com.ojanbelajar.obuce.ui.getstarted

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class GetStartedPagerAdapter(manager: FragmentManager):  FragmentPagerAdapter(manager, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getCount(): Int = 3

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                BasicProfileFragment()
            }
            1 -> {
                GenderFragment()
            }
            else ->{
                return MeasureFragment()
            }
        }
    }
}