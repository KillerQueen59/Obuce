package com.ojanbelajar.obuce.ui.tab.statistic.tab.history

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity
import com.ojanbelajar.obuce.databinding.ActivityListHistoryBinding

class ListHistoryActivity : AppCompatActivity() {

    lateinit var binding:ActivityListHistoryBinding
    private val arraylisthistorylist = ArrayList<HistoryEntity>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataAllList = preparedDataHistoryConsumption()
        arraylisthistorylist.addAll(dataAllList)
        rvSetUpHistoryConsumption()
    }

    private fun preparedDataHistoryConsumption(): ArrayList<HistoryEntity> {
        var name= resources.getStringArray(R.array.dataListHistoryname)
        var time= resources.getStringArray(R.array.dataListHistorytime)
        var day= resources.getStringArray(R.array.dataListHistoryday)
        var calori= resources.getStringArray(R.array.dataListHistorycalori)
        var composition= resources.getStringArray(R.array.dataListHistorycomposition)
        var image = resources.obtainTypedArray(R.array.dataListHistorycompositionimage)
        val arraylistlisthistory = ArrayList<HistoryEntity>()
        for (i in name.indices){
            var listdata = HistoryEntity(name[i], time[i],day[i], calori[i], composition[i],image.getResourceId(i,0))
            arraylistlisthistory.add(listdata)
        }
        return arraylistlisthistory
    }

    private fun rvSetUpHistoryConsumption() {
        binding.rvListallhistoryconsumption.setHasFixedSize(true)
        binding.rvListallhistoryconsumption.layoutManager = LinearLayoutManager(this)
        val adapter = HistoryStatisticAdapter(arraylisthistorylist)
        binding.rvListallhistoryconsumption.adapter = adapter
    }
}