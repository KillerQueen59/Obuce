package com.ojanbelajar.obuce.ui.tab.consult

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ojanbelajar.obuce.databinding.ItemRowConsultBinding
import com.ojanbelajar.obuce.ui.tab.home.workout.WorkoutActivity
import kotlinx.coroutines.NonDisposableHandle.parent

class ConsultAdapter(private val consultArraylisData:ArrayList<Consult>): RecyclerView.Adapter<ConsultAdapter.MyViewHolder>() {
    class MyViewHolder(val binding:ItemRowConsultBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemRowConsultBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val consultData = consultArraylisData[position]
        val contextrvitem = holder.itemView.context
        holder.binding.tvItemName.text = consultData.name
        holder.binding.tvItemCompany.text = consultData.company
        Glide.with(contextrvitem).load(consultData.image)
            .apply(RequestOptions().override(60,60)).
            into(holder.binding.imgItemPhoto)
        holder.binding.btnconsultasiselected.setOnClickListener{
            val movedetailuseractivityworkout = Intent(contextrvitem, ChatConsultActivity::class.java)
            contextrvitem.startActivity(movedetailuseractivityworkout)
        }

    }

    override fun getItemCount(): Int {
        return consultArraylisData.size
    }
}