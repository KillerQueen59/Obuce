package com.ojanbelajar.obuce.ui.tab.statistic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ojanbelajar.obuce.databinding.FragmentStatisticBinding

class StatisticFragment : Fragment() {

//    companion object {
//        private val TAB_TITLES = arrayOf(
//            "Histori",
//            "Data"
//        )
//    }

    private var _binding: FragmentStatisticBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStatisticBinding.inflate(inflater, container, false)
        return binding.root

//        val sectionsPagerAdapter = SectionsPagerAdapter(getActivity())
//        binding.viewpgConsult.adapter = sectionsPagerAdapter
//        val tabs = binding.tabStatistic
//        val viewpg = binding.viewpgConsult
//        TabLayoutMediator(tabs,viewpg){tab,position->
//            tab.text = TAB_TITLES[position]
//        }.attach()


    }
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val binding = FragmentStatiscticBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        // The pager adapter, which provides the pages to the view pager widget.
//        val pagerAdapter = SectionsPagerAdapter(this)
//        binding.viewpgConsult.adapter = pagerAdapter
//        val tabs = binding.tabStatistic
//        val viewpg = binding.viewpgConsult
//        TabLayoutMediator(tabs,viewpg){tab,position->
//            tab.text = TAB_TITLES[position]
//        }.attach()
//    }

//
//        override fun onBackPressed() {
//        if (binding.viewpgConsult.currentItem == 0) {
//            // If the user is currently looking at the first step, allow the system to handle the
//            // Back button. This calls finish() on this activity and pops the back stack.
//            super.onBackPressed()
//        } else {
//            // Otherwise, select the previous step.
//            binding.viewpgConsult.currentItem = binding.viewpgConsult.currentItem - 1
//        }
//    }

//    /**
//     * A simple pager adapter that represents 5 ScreenSlidePageFragment objects, in
//     * sequence.
//     */
//    private inner class ScreenSlidePagerAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
//        override fun getItemCount(): Int = NUM_PAGES
//
//        override fun createFragment(position: Int): Fragment {
//            var fragment: Fragment? = null
//            when (position) {
//                0 -> fragment = HistoryStatisticFragment()
//                1 -> fragment = DataStatisticFragment()
//            }
//            return fragment as Fragment
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}