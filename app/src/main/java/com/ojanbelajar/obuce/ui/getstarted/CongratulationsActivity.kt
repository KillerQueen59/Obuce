package com.ojanbelajar.obuce.ui.getstarted

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ojanbelajar.obuce.databinding.ActivityCongratulationBinding
import com.ojanbelajar.obuce.ui.login.LoginActivity
import org.jetbrains.anko.clearTask
import org.jetbrains.anko.intentFor

class CongratulationsActivity: AppCompatActivity() {

    companion object {
        const val EXTRA_BMI = "extra_bmi"
    }

    lateinit var binding: ActivityCongratulationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCongratulationBinding.inflate(layoutInflater)
        setContentView(binding.root);

        displayContent()

        binding.btnContinue.setOnClickListener {
            startActivity(intentFor<LoginActivity>().clearTask().addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP).addFlags(
                Intent.FLAG_ACTIVITY_NEW_TASK))        }
    }

    private fun displayContent() {
        // get intent
        val bmi = intent.getDoubleExtra(EXTRA_BMI, 0.0)
        val roundedBmi = String.format("%.2f", bmi).toDouble()
        val classification = getClassification(bmi)

        // display output
        binding.tvBmi.text = roundedBmi.toString()
        binding.tvClassification.text = classification
    }

    private fun getClassification(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 22.9 -> "Normal"
            bmi < 24.9 -> "Overweight"
            bmi < 29.9 -> "Pre-Obese"
            bmi < 40 -> "Obese"
            bmi < 50 -> "Morbid Obese"
            else -> "Super Obese"
        }
    }


}