package com.ojanbelajar.obuce.ui.getstarted

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.ojanbelajar.obuce.databinding.ActivityGetStartedBinding
import org.jetbrains.anko.startActivity

class GetStartedActivity: AppCompatActivity() {

    lateinit var binding: ActivityGetStartedBinding
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        setContentView(binding.root)
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
            startActivity<CongratulationsActivity>()
        }
    }
}