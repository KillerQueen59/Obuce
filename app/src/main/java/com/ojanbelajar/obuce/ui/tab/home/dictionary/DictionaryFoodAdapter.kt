package com.ojanbelajar.obuce.ui.tab.home.dictionary

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.DictionaryEntity
import com.ojanbelajar.obuce.databinding.BottomPopupBinding
import com.ojanbelajar.obuce.databinding.ItemDictionaryBinding
import org.jetbrains.anko.layoutInflater

class DictionaryFoodAdapter ( private val listDictionary: ArrayList<DictionaryEntity>,private val context: Context) :
    RecyclerView.Adapter<DictionaryFoodAdapterViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryFoodAdapterViewHolder =
        DictionaryFoodAdapterViewHolder(ItemDictionaryBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    @SuppressLint("InflateParams")
    override fun onBindViewHolder(holder: DictionaryFoodAdapterViewHolder, position: Int) {
        val dictionary = listDictionary[position]
        holder.bind(dictionary)
        holder.itemView.setOnClickListener {
            val view = context.layoutInflater.inflate(R.layout.bottom_popup, null)
            val dialog = BottomSheetDialog(context)
            dialog.setContentView(view)
            dialog.show()
        }
    }

    override fun getItemCount(): Int {
        return listDictionary.size
    }

}

class DictionaryFoodAdapterViewHolder(private val binding: ItemDictionaryBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(dictionary: DictionaryEntity){
        binding.titleDictionary.text = dictionary.title
        binding.detailDictionary.text = dictionary.detail

    }

}
