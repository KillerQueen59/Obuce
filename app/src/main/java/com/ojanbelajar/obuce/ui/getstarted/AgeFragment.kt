package com.ojanbelajar.obuce.ui.getstarted

import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ojanbelajar.obuce.databinding.FragmentAgeBinding
import java.time.LocalDate
import java.time.ZoneId
import java.util.*
import android.R




class AgeFragment: Fragment() {

    lateinit var binding: FragmentAgeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getCurrentDate()
    }

    private fun getCurrentDate(){
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]
        binding.date.text = day.toString()
        binding.month.text = pickMonth(month)
        binding.year.text = year.toString()
    }

/*    private fun pickDate(){
        val datePickerDialog = DatePickerDialog(
            requireContext(), R.style.M, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        )

    }*/

    private fun pickMonth(month: Int): String{
        when(month){
            1-> return "Jan"
            2-> return "Feb"
            3-> return "Mar"
            4-> return "Apr"
            5-> return "May"
            6-> return "Jun"
            7-> return "Jul"
            8-> return "Aug"
            9-> return "Sep"
            10-> return "Oct"
            11-> return "Nov"
            12-> return "Dec"
        }
        return ""
    }
}