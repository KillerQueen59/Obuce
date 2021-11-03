package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.ojanbelajar.obuce.data.source.local.entity.UserEntity
import com.ojanbelajar.obuce.databinding.FragmentSignupSummaryBinding
import java.util.*

class SignupSummaryFragment : Fragment() {

    private lateinit var binding:FragmentSignupSummaryBinding
    private val viewModel: SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignupSummaryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayUserData()
    }

    private fun displayUserData() {
        // Observer
        val userObserver = Observer<UserEntity> { data->
            binding.tvName.text = data.name
            binding.tvEmail.text = data.email
            binding.tvGender.text = getGender(data.gender)
            binding.tvBirthdate.text = getDate(data.birthdate)
            binding.tvHeight.text = data.height.toString()
            binding.tvWeight.text = data.weight.toString()
        }
        viewModel.getData().observe(viewLifecycleOwner, userObserver)


        /*binding.tvName.text = userInputData.name
        binding.tvEmail.text = userInputData.email
        if (userInputData.gender == 1) {
            binding.tvGender.text = "Male"
        } else {
            binding.tvGender.text = "Female"
        }

        //val dateString = userInputData.birthdate.toString()
        //val birthdate = SimpleDateFormat("EEE MMM dd HH:mm:ss GMYXXX yyyy").parse(dateString)
        //val formattedDate = SimpleDateFormat("dd MMM yyyy").format(birthdate)
        //binding.tvBirthdate.text =  //userInputData.birthdate.toString()
        val year = userInputData.birthdate.year+1900
        val month = userInputData.birthdate.month+1
        val date = userInputData.birthdate.date
        val birthdate = "$date/$month/$year"
        binding.tvBirthdate.text = birthdate
        binding.tvHeight.text = userInputData.height.toString()
        binding.tvWeight.text = userInputData.weight.toString()*/

    }

    private fun getGender(gender: Int): String {
        if (gender == 0){
            return "female"
        } else {
            return "male"
        }
    }

    private fun getDate(date: Date): String {
        val year = date.year+1900
        val month = date.month+1
        val date = date.date
        val birthdate = "$date/$month/$year"
        return birthdate
    }
}