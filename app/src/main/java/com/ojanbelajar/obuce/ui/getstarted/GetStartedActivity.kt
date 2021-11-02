package com.ojanbelajar.obuce.ui.getstarted

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.ojanbelajar.obuce.data.source.Resource
import com.ojanbelajar.obuce.data.source.local.entity.UserEntity
import com.ojanbelajar.obuce.data.source.remote.body.LoginBody
import com.ojanbelajar.obuce.data.source.remote.body.SignupBody
import com.ojanbelajar.obuce.data.source.remote.response.SignupResponse
import com.ojanbelajar.obuce.databinding.ActivityGetStartedBinding
import com.ojanbelajar.obuce.ui.login.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import org.jetbrains.anko.alert
import org.jetbrains.anko.db.NULL
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.yesButton
import java.util.*

@AndroidEntryPoint
class GetStartedActivity: AppCompatActivity() {

    lateinit var binding: ActivityGetStartedBinding
    lateinit var viewModel: SignUpViewModel
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =  ViewModelProvider(this).get(SignUpViewModel::class.java)

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
                    3 -> {
                        binding.btnLeft.visibility = View.VISIBLE
                        binding.btnRight.visibility = View.VISIBLE
                        binding.btnContinue.visibility = View.GONE
                    }
                    4 ->{
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
            if (position < 5) {
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
                Log.d("SignUpPW", data.password)
                Log.d("SignUpGender", data.gender.toString())
                Log.d("SignUpBirthdate", data.birthdate.toString())
                Log.d("SignUpHeight", data.height.toString())
                Log.d("SignUpWeight", data.weight.toString())
            }
            viewModel.getData().observe(this, userObserver)*/

            /*Log.d("SignUpName", viewModel.signUpData.name)
            Log.d("SignUpEmail", viewModel.signUpData.email)
            Log.d("SignUpPW", viewModel.signUpData.password)
            Log.d("SignUpGender", viewModel.signUpData.gender.toString())
            Log.d("SignUpBirthdate", viewModel.signUpData.birthdate.toString())
            Log.d("SignUpHeight", viewModel.signUpData.height.toString())
            Log.d("SignUpWeight", viewModel.signUpData.weight.toString())*/
            //startActivity<CongratulationsActivity>()
            //val data = viewModel.getData()
            //Log.d("Nama", data.value?.name.toString())
            prepareSignup()
        }
    }

    private fun prepareSignup(){
        // ambil data signup
        val data = viewModel.getFixData()

        if (data != null) {
            // fungsi signupDataReady -> mengecek kelengkapan data


            if (true) {//signupDataReady){
                val body = SignupBody(
                    name = data.name,
                    email = data.email,
                    password = data.password,
                    gender = getGender(data.gender),
                    weight = data.weight,
                    height = data.height,
                    birthdate = getDate(data.birthdate)
                )

                viewModel.signup(body).observe(this, { result ->
                    if (result != null) {
                        when (result) {
                            is Resource.Loading -> {
                                binding.progressBar.visibility = View.VISIBLE
                            }
                            is Resource.Success -> {
                                binding.progressBar.visibility = View.GONE
                                alert("Sign Up Success")

                                result.data?.let { moveToCongratulationsActivity(it) }
                                // startActivity<CongratulationsActivity>()
                            }
                            is Resource.Error -> {
                                binding.progressBar.visibility = View.GONE
                                alert(result.message.toString()) {
                                    yesButton {}
                                }.show()
                            }
                        }
                    }

                })
            }
        } else {
            alert("Can't get the data")
        }
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

    private fun moveToCongratulationsActivity(userData: SignupResponse) {
        val congratulationsIntent = Intent(this@GetStartedActivity, CongratulationsActivity::class.java)
        congratulationsIntent.putExtra(CongratulationsActivity.EXTRA_BMI, userData.user.bmi)
        startActivity(congratulationsIntent)
    }
}