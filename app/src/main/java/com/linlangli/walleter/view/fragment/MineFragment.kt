package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentMineBinding
import com.linlangli.walleter.utils.Loger

class MineFragment : BaseFragment<FragmentMineBinding>(){
    override fun layoutId() = R.layout.fragment_mine

    override fun initVM() {
    }

    override fun iniView() {
    }

    override fun iniData() {
        Loger.e("ClockFragment")
    }
}