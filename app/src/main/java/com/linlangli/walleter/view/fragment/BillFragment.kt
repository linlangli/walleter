package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentBillBinding
import com.linlangli.walleter.model.Bill
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.view.adapter.MainAdapter

class BillFragment : BaseFragment<FragmentBillBinding>() {
    override fun layoutId() = R.layout.fragment_bill

    override fun initVM() {
    }

    override fun iniView() {
    }

    override fun iniData() {
        Loger.d("iniData")
    }
}