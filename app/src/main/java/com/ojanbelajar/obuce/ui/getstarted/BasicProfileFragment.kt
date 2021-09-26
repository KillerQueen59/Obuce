package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ojanbelajar.obuce.databinding.FragmentBasicProfileBinding

class BasicProfileFragment: Fragment() {


    lateinit var binding: FragmentBasicProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasicProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    fun isCheck(){

    }
}