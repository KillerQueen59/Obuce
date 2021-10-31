package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.FragmentGenderBinding

class GenderFragment: Fragment() {


    lateinit var binding: FragmentGenderBinding
    private val viewModel: SignUpViewModel by activityViewModels()

    var isMale = true
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGenderBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lnMale.setOnClickListener {
            if (!isMale) isMale = !isMale
            setSrc(isMale)
        }
        binding.lnFemale.setOnClickListener {
            if (isMale) isMale = !isMale
            setSrc(isMale)
        }
    }

    override fun onPause() {
        super.onPause()
        if (isMale) {
            viewModel.signUpData.gender = 1
        } else {
            viewModel.signUpData.gender = 0
        }
    }

    private fun setSrc(isMale: Boolean){
        if (isMale){
            Glide.with(this).load(R.drawable.male_selected).into(binding.imgMale)
            Glide.with(this).load(R.drawable.female).into(binding.imgFemale)
        } else {
            Glide.with(this).load(R.drawable.male).into(binding.imgMale)
            Glide.with(this).load(R.drawable.female_selected).into(binding.imgFemale)
        }
    }
}