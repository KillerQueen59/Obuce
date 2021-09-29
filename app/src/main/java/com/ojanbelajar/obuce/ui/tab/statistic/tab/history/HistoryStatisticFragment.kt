package com.ojanbelajar.obuce.ui.tab.statistic.tab.history

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.HistoryEntity
import com.ojanbelajar.obuce.databinding.FragmentHistoryStaticticBinding
import org.jetbrains.anko.support.v4.startActivity


class HistoryStatisticFragment : Fragment() {

    private val arraylisthistorylist = ArrayList<HistoryEntity>()
    private var _binding: FragmentHistoryStaticticBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHistoryStaticticBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataAllList = preparedDataHistoryConsumption()
        arraylisthistorylist.addAll(dataAllList)
        rvSetUpHistoryConsumption()

        binding.tvSeeAllHistoryListConsumption.setOnClickListener {
            startActivity<ListHistoryActivity>()
        }
    }

    private fun preparedDataHistoryConsumption(): ArrayList<HistoryEntity> {
        var name= resources.getStringArray(R.array.dataListHistoryname)
        var time= resources.getStringArray(R.array.dataListHistorytime)
        var day= resources.getStringArray(R.array.dataListHistoryday)
        var calori= resources.getStringArray(R.array.dataListHistorycalori)
        var composition= resources.getStringArray(R.array.dataListHistorycomposition)
        var image = resources.obtainTypedArray(R.array.dataListHistorycompositionimage)
        val arraylistlisthistory = ArrayList<HistoryEntity>()
        for (i in 0 until 2){
            var listdata = HistoryEntity(name[i], time[i],day[i], calori[i], composition[i],image.getResourceId(i,0))
            arraylistlisthistory.add(listdata)
        }
        return arraylistlisthistory
    }

    private fun rvSetUpHistoryConsumption() {
        binding.rvHistorycompsumtionheadline.setHasFixedSize(true)
        binding.rvHistorycompsumtionheadline.layoutManager = LinearLayoutManager(activity)
        val adapter = HistoryStatisticAdapter(arraylisthistorylist)
        binding.rvHistorycompsumtionheadline.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}