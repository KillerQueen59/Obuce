package com.ojanbelajar.obuce.ui.tab.statistic

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ojanbelajar.obuce.ui.tab.statistic.tab.data.DataStatisticFragment
import com.ojanbelajar.obuce.ui.tab.statistic.tab.history.HistoryStatisticFragment

private const val NUM_PAGES = 2
class SectionsPagerAdapter (activity: FragmentActivity) : FragmentStateAdapter(activity){
    override fun getItemCount(): Int {
        return NUM_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HistoryStatisticFragment()
            1 -> fragment = DataStatisticFragment()
        }
        return fragment as Fragment
    }
}