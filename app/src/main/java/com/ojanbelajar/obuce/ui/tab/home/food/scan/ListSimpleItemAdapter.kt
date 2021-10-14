package com.ojanbelajar.obuce.ui.tab.home.food.scan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ojanbelajar.obuce.R

class ListSimpleItemAdapter(private val listHowToScan: ArrayList<String>): RecyclerView.Adapter<ListSimpleItemAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvStep: TextView = itemView.findViewById(R.id.tv_simple_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_simple_list, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val step = listHowToScan[position]

        holder.tvStep.text = step

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listHowToScan[holder.adapterPosition])}
    }

    override fun getItemCount(): Int {
        return listHowToScan.size
    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: String)
    }

}