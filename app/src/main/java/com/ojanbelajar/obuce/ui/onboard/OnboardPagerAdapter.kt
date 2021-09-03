package com.ojanbelajar.obuce.ui.onboard

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import android.R
import android.util.Log

import android.widget.TextView

import android.view.LayoutInflater
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.ojanbelajar.obuce.databinding.OnboardItemBinding


class OnboardPagerAdapter(private val context: Context,private val data: ArrayList<Onboard>): PagerAdapter() {

    override fun getCount(): Int = data.size

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding = OnboardItemBinding.inflate(inflater)
        binding.txtOnboardTitle.text = data[position].title
        binding.txtOnboardDesc.text = data[position].description
        Glide.with(context).load(data[position].image).into(binding.imgOnboard)
        container.addView(binding.root)
        return binding.root
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }
}