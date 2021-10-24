package com.ojanbelajar.obuce.ui.onboard

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayout
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ActivityOnboardBinding
import com.ojanbelajar.obuce.ui.login.LoginActivity
import com.ojanbelajar.obuce.utils.SessionManagement
import org.jetbrains.anko.startActivity

class OnboardActivity: AppCompatActivity() {

    lateinit var binding: ActivityOnboardBinding
    var onboardItem = ArrayList<Onboard>()
    var position = 0
    lateinit var session: SessionManagement

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOnboardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        session = SessionManagement(this)
        if(session.isFirstOpen) toLogin()
        actionBar?.hide()
        defineData()
    }

    fun defineData(){
        onboardItem.add(Onboard("Diet Recommendation","We provide you the best diet you can get", R.drawable.onboard1))
        onboardItem.add(Onboard("Burn your calories","Balance your intake by doing exercises", R.drawable.onboard2))
        onboardItem.add(Onboard("Get updates for \n" + "healthy lifestyle","Lorem ipsum dolor sit amet, consectetur adipiscing elit. Lorem nisi, consectetur sed nam. Commodo euismod sagittis nisi in sed. Tempus, at viverra orci dolor, dolor ac quis arcu. Id fringilla arcu morbi neque.", R.drawable.onboard3))

        binding.pagerOnboard.adapter = OnboardPagerAdapter(this,onboardItem)
        binding.tabLayout.setupWithViewPager(binding.pagerOnboard)

        binding.btnRight.setOnClickListener {
            position = binding.pagerOnboard.currentItem;
            if (position < onboardItem.size) {
                position++
                binding.pagerOnboard.currentItem = position
            }
        }

        binding.btnLeft.setOnClickListener {
            position = binding.pagerOnboard.currentItem;
            if (position > 0) {
                position--
                binding.pagerOnboard.currentItem = position
            }
        }
        binding.btnContinue.setOnClickListener {
            startActivity<LoginActivity>()
        }
        binding.tabLayout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when(tab?.position){
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
                    2 ->{
                        binding.btnLeft.visibility = View.VISIBLE
                        binding.btnRight.visibility = View.GONE
                        binding.btnContinue.visibility = View.VISIBLE
                    }
                }
            }
            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
    fun toLogin() {
        startActivity<LoginActivity>()
        session.createOnBoardSession()
        finish()
    }


}