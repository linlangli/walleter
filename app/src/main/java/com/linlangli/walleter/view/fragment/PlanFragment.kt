package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentPlanBinding
import com.linlangli.walleter.utils.Loger

class PlanFragment : BaseFragment<FragmentPlanBinding>(){
    override fun layoutId() = R.layout.fragment_plan

    override fun initVM() {
    }

    override fun iniView() {
    }

    override fun iniData() {
        Loger.e("ClockFragment")
    }
}