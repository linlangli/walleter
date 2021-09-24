package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentChartBinding
import com.linlangli.walleter.utils.Loger

class ChartFragment : BaseFragment<FragmentChartBinding>(){
    override fun layoutId() = R.layout.fragment_chart

    override fun initVM() {
    }

    override fun iniView() {
    }

    override fun iniData() {
        Loger.e("ChartFragment")
    }

}