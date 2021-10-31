package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.ojanbelajar.obuce.databinding.FragmentAgeBinding
import java.util.*


class AgeFragment: Fragment() {

    lateinit var binding: FragmentAgeBinding
    private val viewModel: SignUpViewModel by activityViewModels()

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
        //getCurrentDate()
    }

    override fun onPause() {
        super.onPause()

        /*//val datePicker = binding.edtBirthDate
        val dateSet = Calendar.getInstance()
        binding.edtBirthDate.init(dateSet.get(Calendar.YEAR), dateSet.get(Calendar.MONTH), dateSet.get(Calendar.DAY_OF_MONTH)){
            view, year, month, day ->
            viewModel.signUpData.birthdate = Date(year, month, day)
        }*/
        var day = binding.edtBirthDate.dayOfMonth
        var month = binding.edtBirthDate.month
        var year = binding.edtBirthDate.year-1900
        viewModel.signUpData.birthdate = Date(year, month, day)
    }

    /*private fun getCurrentDate(){
        val cal = Calendar.getInstance()
        val year = cal[Calendar.YEAR]
        val month = cal[Calendar.MONTH]
        val day = cal[Calendar.DAY_OF_MONTH]
        binding.date.text = day.toString()
        binding.month.text = pickMonth(month)
        binding.year.text = year.toString()
    }*/

/*    private fun pickDate(){
        val datePickerDialog = DatePickerDialog(
            requireContext(), R.style.M, date, myCalendar
                .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
            myCalendar.get(Calendar.DAY_OF_MONTH)
        )

    }*/

    /*private fun pickMonth(month: Int): String{
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
    }*/
}