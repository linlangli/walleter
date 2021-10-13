package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentBillBinding
import com.linlangli.walleter.model.Bill
import com.linlangli.walleter.view.adapter.MainAdapter

class BillFragment : BaseFragment<FragmentBillBinding>() {
    override fun layoutId() = R.layout.fragment_bill

    override fun initVM() {
    }

    override fun iniView() {
    }

    override fun iniData() {
//        val data = listOf(Bill("test", "123", "test", "test", 12f))

//        binder.recyclerMain.init(
//            context,
//            MainAdapter(
//                context,
//                R.layout.item_main,
//                data
//            )
//        )
    }

    override fun navControllerId() = -1
}