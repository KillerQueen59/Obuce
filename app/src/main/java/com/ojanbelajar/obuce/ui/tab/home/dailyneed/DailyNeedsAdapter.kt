package com.ojanbelajar.obuce.ui.tab.home.dailyneed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.DailyNutritionEntity

class DailyNeedsAdapter(private val listDailyNeeds: ArrayList<DailyNutritionEntity>): RecyclerView.Adapter<DailyNeedsAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: DailyNeedsAdapter.OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_dailyneeds_name)
        var tvValue: TextView = itemView.findViewById(R.id.tv_dailyneeds_value)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_daily_needs, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listDailyNeeds[position]
        val tempAmount = "${item.amount} ${item.type}"

        holder.tvName.text = item.name
        holder.tvValue.text = tempAmount

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listDailyNeeds[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listDailyNeeds.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: DailyNutritionEntity)
    }

}