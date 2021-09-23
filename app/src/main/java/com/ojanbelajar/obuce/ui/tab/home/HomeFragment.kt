package com.ojanbelajar.obuce.ui.tab.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ojanbelajar.obuce.databinding.FragmentHomeBinding
import org.jetbrains.anko.support.v4.startActivity


class HomeFragment : Fragment() {

    companion object {

        private const val ARG_SECTION_NUMBER = "section_number"

        @JvmStatic
        fun newInstance(index: Int) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, index)
                }
            }
    }

    private var _binding: FragmentHomeBinding?=null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val index = arguments?.getInt(ARG_SECTION_NUMBER, 0)
//        binding.tvhome.text = "home"
        binding.cvChooseworkout.setOnClickListener {
            startActivity<WorkoutMethodeActivity>()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}