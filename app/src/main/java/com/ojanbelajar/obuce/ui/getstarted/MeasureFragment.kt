package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ojanbelajar.obuce.databinding.FragmentMeasureBinding

class MeasureFragment: Fragment() {


    private lateinit var binding: FragmentMeasureBinding
    private val viewModel: SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMeasureBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDetach() {
        super.onDetach()

        val lastData = viewModel.getFixData()
        if (lastData != null) {
            val updateData = lastData
            updateData.height = binding.edtHeight.text.toString().toDouble()
            updateData.weight = binding.edtWeight.text.toString().toDouble()
            viewModel.editData(updateData)
        }
        Log.d("MeasureFragment", "Detach")
    }

    override fun onPause() {
        super.onPause()

        val lastData = viewModel.getFixData()
        if (lastData != null) {
            val updateData = lastData
            updateData.height = binding.edtHeight.text.toString().toDouble()
            updateData.weight = binding.edtWeight.text.toString().toDouble()
            viewModel.editData(updateData)
        }
        Log.d("MeasureFragment", "Pause")
        /*//Log.d("MeasureFragmentW", binding.edtWeight.text.toString())
        //Log.d("MeasureFragmentH", binding.edtHeight.text.toString())
        viewModel.signUpData.weight = binding.edtWeight.text.toString().toDouble()
        viewModel.signUpData.height = binding.edtHeight.text.toString().toDouble()
        //val weight = binding.edtWeight.text.toString().toDouble()
        //viewModel.signUpData.weight = weight
        //val height = binding.edtHeight.text.toString().toDouble()
        //viewModel.signUpData.height = height*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("MeasureFragment", "destroyed")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MeasureFragment", "resume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MeasureFragment", "stop")
    }

}