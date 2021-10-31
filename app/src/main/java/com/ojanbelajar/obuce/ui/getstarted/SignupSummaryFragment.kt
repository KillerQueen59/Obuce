package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ojanbelajar.obuce.databinding.FragmentSignupSummaryBinding

class SignupSummaryFragment : Fragment() {

    private lateinit var binding:FragmentSignupSummaryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupSummaryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }



}