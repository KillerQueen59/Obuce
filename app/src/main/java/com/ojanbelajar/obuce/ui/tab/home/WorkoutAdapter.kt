package com.ojanbelajar.obuce.ui.tab.home

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ItemListWorkoutBinding
import com.ojanbelajar.obuce.databinding.OnboardItemBinding
import com.ojanbelajar.obuce.ui.onboard.Onboard
class WorkoutAdapter(private val context: Context,private val listWorkout: ArrayList<Workout>) : RecyclerView.Adapter<WorkoutAdapter.ListViewHolder>(){
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.civ_workout)
        var tvtitle: TextView = itemView.findViewById(R.id.tv_title_workout)
        var tvtime: TextView = itemView.findViewById(R.id.tv_time_workout)
//        var recyclerView:RecyclerView = itemView.findViewById(R.id.rv_listworkout)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item_list_workout, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val listworkoutt = listWorkout[position]
        Glide.with(context).load(listworkoutt.image).apply(RequestOptions().override(75,75)).into(holder.imgPhoto)
        holder.tvtitle.text = listworkoutt.title
        holder.tvtime.text = listworkoutt.time

        holder.itemView.setOnClickListener{
            val movedetailuseractivityworkout = Intent(context,WorkoutActivity::class.java)
            context.startActivity(movedetailuseractivityworkout)
//            movedetailuseractivityworkout.putExtra(DetailUserActivity.EXTRA_DATA,dataUser)
//            mContextt.startActivity(movedetailuseractivity)
        }
    }

    override fun getItemCount(): Int {
        return listWorkout.size
    }

}
//class WorkoutAdapter (private val context: Context, private val data: ArrayList<Workout>): PagerAdapter() {
//    override fun getCount(): Int {
//        return data.size
//    }
//
//    override fun isViewFromObject(view: View, `object`: Any): Boolean {
//        return view == `object`
//    }
//
//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val binding = ItemListWorkoutBinding.inflate(inflater)
//        Glide.with(context).load(data[position].image).into(binding.civWorkout)
//        binding.tvTitleWorkout.text = data[position].title
//        binding.tvTimeWorkout.text = data[position].time
//        return binding.root
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
//        container.removeView(`object` as View?)
//    }
//}