package com.ojanbelajar.obuce.ui.tab.home.food.scan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ojanbelajar.obuce.R

class NutritionsFactsAdapter(private val listNutritionsFacts: ArrayList<NutritionValue>): RecyclerView.Adapter<NutritionsFactsAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.nutrition_name)
        var tvMass: TextView = itemView.findViewById(R.id.nutrition_mass)
        var tvMassUnit: TextView = itemView.findViewById(R.id.nutrition_mass_unit)
        var tvPercentage: TextView = itemView.findViewById(R.id.nutrition_daily_value_percentage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_nutrition_daily_value, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = listNutritionsFacts[position]

        holder.tvName.text = item.name
        holder.tvMass.text = item.mass.toString()
        holder.tvMassUnit.text = item.unit
        holder.tvPercentage.text = item.percentage.toString()

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listNutritionsFacts[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listNutritionsFacts.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: NutritionValue)
    }

}