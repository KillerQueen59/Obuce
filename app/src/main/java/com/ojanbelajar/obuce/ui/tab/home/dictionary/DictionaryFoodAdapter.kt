package com.ojanbelajar.obuce.ui.tab.home.dictionary

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.databinding.ItemDictionaryBinding
import kotlinx.android.synthetic.main.bottom_popup.view.*
import org.jetbrains.anko.layoutInflater

class DictionaryFoodAdapter ( private val listDictionary: ArrayList<DictionaryData>,private val context: Context) :
    RecyclerView.Adapter<DictionaryFoodAdapterViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryFoodAdapterViewHolder =
        DictionaryFoodAdapterViewHolder(ItemDictionaryBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    @SuppressLint("InflateParams")
    override fun onBindViewHolder(holder: DictionaryFoodAdapterViewHolder, position: Int) {
        val dictionary = listDictionary[position]
        holder.bind(dictionary)
        holder.itemView.setOnClickListener {
            val view = context.layoutInflater.inflate(R.layout.bottom_popup, null)
            view.back_popup.background.alpha = 100
            val dialog = BottomSheetDialog(context)
            dialog.behavior.isDraggable = false
            dialog.setContentView(view)
            dialog.show()

            view.tv_dictionary_popup_name.text = dictionary.name
            view.tv_dictionary_popup_description.text = dictionary.description
        }
    }

    override fun getItemCount(): Int {
        return listDictionary.size
    }

}

class DictionaryFoodAdapterViewHolder(private val binding: ItemDictionaryBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(dictionary: DictionaryData){
        binding.titleDictionary.text = dictionary.name
        binding.detailDictionary.text = dictionary.description
    }

}
