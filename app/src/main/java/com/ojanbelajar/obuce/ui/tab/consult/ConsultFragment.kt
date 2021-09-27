package com.ojanbelajar.obuce.ui.tab.consult

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.ojanbelajar.obuce.R
import com.ojanbelajar.obuce.data.source.local.entity.ConsultEntity
import com.ojanbelajar.obuce.databinding.FragmentConsultBinding


class ConsultFragment : Fragment() {

    private var _binding: FragmentConsultBinding?=null
    private val binding get() = _binding!!
    val arraylistConsultData = ArrayList<ConsultEntity>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentConsultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addAllData = preparedData()
        arraylistConsultData.addAll(addAllData)
        rvListSetup()

    }

    private fun preparedData(): ArrayList<ConsultEntity> {
        val dataname = resources.getStringArray(R.array.datanameconsult)
        val datacompany = resources.getStringArray(R.array.dataconsulltcompany)
        val dataPhoto = resources.obtainTypedArray(R.array.dataimage)
        val listconsult = ArrayList<ConsultEntity>()
        for (i in dataname.indices) {
            val work = ConsultEntity(dataname[i], datacompany[i], dataPhoto.getResourceId(i, 0))
            listconsult.add(work)
        }

        return listconsult
    }

    private fun rvListSetup() {
        binding.rvListtconsult.setHasFixedSize(true)
        binding.rvListtconsult.layoutManager = LinearLayoutManager(activity)
        val adapterConsult = ConsultAdapter(arraylistConsultData)
        binding.rvListtconsult.adapter = adapterConsult
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}