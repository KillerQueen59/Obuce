package com.ojanbelajar.obuce.ui.tab.statistic.tab.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity
import com.ojanbelajar.obuce.databinding.ItemHistoryStatisticBinding

class HistoryStatisticAdapter(private val arraylishistorytdata:List<HistoryEntity>)
    : RecyclerView.Adapter<HistoryStatisticAdapter.MyViewHolder>() {
    class MyViewHolder(val binding:ItemHistoryStatisticBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemHistoryStatisticBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val historyArray = arraylishistorytdata[position]
        val mContext = holder.itemView.context
        holder.binding.tvNameConsume.text = historyArray.name
        holder.binding.tvTimeLocal.text = historyArray.time
        holder.binding.tvDateMonth.text = historyArray.day
        holder.binding.tvCalorie.text = historyArray.calori
        holder.binding.tvComposition.text = historyArray.composition
        Glide.with(mContext).load(historyArray.image)
            .apply(RequestOptions().override(60,60))
            .into(holder.binding.ivConsumption)
    }

    override fun getItemCount(): Int {
        return arraylishistorytdata.size
    }
}