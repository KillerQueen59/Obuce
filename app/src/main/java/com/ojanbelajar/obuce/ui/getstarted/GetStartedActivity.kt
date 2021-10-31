package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.ojanbelajar.obuce.databinding.ActivityGetStartedBinding
import org.jetbrains.anko.startActivity

class GetStartedActivity: AppCompatActivity() {

    lateinit var binding: ActivityGetStartedBinding
    lateinit var viewModel: SignUpViewModel
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //val viewModel: SignUpViewModel by viewModels()
        viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            SignUpViewModel::class.java)

        binding.pagerGetstarted.adapter = GetStartedPagerAdapter(supportFragmentManager)
        binding.pagerGetstarted.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                when(position){
                    0 -> {
                        binding.btnLeft.visibility = View.GONE
                        binding.btnRight.visibility = View.VISIBLE
                        binding.btnContinue.visibility = View.GONE
                    }
                    1 -> {
                        binding.btnLeft.visibility = View.VISIBLE
                        binding.btnRight.visibility = View.VISIBLE
                        binding.btnContinue.visibility = View.GONE
                    }
                    2 -> {
                        binding.btnLeft.visibility = View.VISIBLE
                        binding.btnRight.visibility = View.VISIBLE
                        binding.btnContinue.visibility = View.GONE
                    }
                    3 ->{
                        binding.btnLeft.visibility = View.VISIBLE
                        binding.btnRight.visibility = View.GONE
                        binding.btnContinue.visibility = View.VISIBLE
                    }
                }
            }

            override fun onPageScrollStateChanged(state: Int) {
            }

        })

        binding.btnRight.setOnClickListener {
            position = binding.pagerGetstarted.currentItem;
            if (position < 4) {
                position++
                binding.pagerGetstarted.currentItem = position
            }
        }
        binding.btnLeft.setOnClickListener {
            position = binding.pagerGetstarted.currentItem;
            if (position > 0) {
                position--
                binding.pagerGetstarted.currentItem = position
            }
        }
        binding.btnContinue.setOnClickListener {
            /*val userObserver = Observer<UserEntity> { data->
                Log.d("SignUpName", data.name)
                Log.d("SignUpEmail", data.email)
            }
            viewModel.getUser().observe(this, userObserver)*/
            Log.d("SignUpName", viewModel.signUpData.name)
            Log.d("SignUpEmail", viewModel.signUpData.email)
            Log.d("SignUpPW", viewModel.signUpData.password)
            Log.d("SignUpGender", viewModel.signUpData.gender.toString())
            Log.d("SignUpBirthdate", viewModel.signUpData.birthdate.toString())
            Log.d("SignUpHeight", viewModel.signUpData.height.toString())
            Log.d("SignUpWeight", viewModel.signUpData.weight.toString())
            startActivity<CongratulationsActivity>()
        }
    }
}