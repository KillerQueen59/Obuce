package com.ojanbelajar.obuce.ui.tab.statistic.tab.data

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ojanbelajar.obuce.databinding.FragmentDataStatisticBinding


class DataStatisticFragment : Fragment() {

    private var _binding: FragmentDataStatisticBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentDataStatisticBinding.inflate(inflater, container, false)
        return binding.root
    }


}