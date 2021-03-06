package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ojanbelajar.obuce.databinding.FragmentBasicProfileBinding

class BasicProfileFragment: Fragment() {


    lateinit var binding: FragmentBasicProfileBinding

    private val viewModel: SignUpViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBasicProfileBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /*// Create Observer
        val userObserver = Observer<UserEntity> { user ->
            binding.edtName.setText(user.name)
            binding.edtEmail.setText(user.email)
            binding.edtPassword.setText(user.password)
        }
        viewModel.getData().observe(viewLifecycleOwner, userObserver)*/

    }

    override fun onDetach() {
        super.onDetach()
        val lastData = viewModel.getFixData()
        if (lastData != null) {
            val updateData = lastData
            updateData.name = binding.edtName.text.toString()
            updateData.email = binding.edtEmail.text.toString()
            updateData.password = binding.edtPassword.text.toString()

            viewModel.editData(updateData)
        }
        Log.d("BasicProfile", "Detach")
    }

    override fun onPause() {
        super.onPause()
        val lastData = viewModel.getFixData()
        if (lastData != null) {
            val updateData = lastData
            updateData.name = binding.edtName.text.toString()
            updateData.email = binding.edtEmail.text.toString()
            updateData.password = binding.edtPassword.text.toString()

            viewModel.editData(updateData)
        }
    }

    fun isChecked(): Boolean{
        var checklist = true
        if (binding.edtName.text.isNullOrEmpty()) {
            binding.edtName.error = "Please enter your name first!"
            checklist = false
        }
        if (binding.edtEmail.text.isNullOrEmpty()) {
            binding.edtEmail.error = "Please enter your email first!"
            checklist = false
        }
        if (binding.edtPassword.text.isNullOrEmpty()) {
            binding.edtPassword.error = "Please enter password you want to use!"
            checklist = false
        } else if (binding.edtPassword.text.toString().length >= 8) {
            binding.edtPassword.error = "Password must have 8 characters at least"
            checklist = false
        }

        return checklist
    }
}