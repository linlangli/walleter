package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.ext.init
import com.linlangli.pangtouyu.view.adapter.BaseAdapter
import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.BR
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentBillBinding
import com.linlangli.walleter.model.Bill
import com.linlangli.walleter.model.User
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.viewmodel.MainViewModel

class BillFragment : BaseFragment<FragmentBillBinding>() {
    override fun layoutId() = R.layout.fragment_bill

    override fun initVM() {
    }

    override fun iniView() {
        val bill1 = Bill(
            "2021年",
            "123",
            "通讯",
            "我的电话",
            123f,
        )
        val bill2 = Bill(
            "2021年",
            "e3333",
            "fedef",
            "我的fef",
            123f,
            R.layout.item_bill_title
        )

        val user1 = User(
            "userid",
            "222"
        )

        val adapter = BaseAdapter.Builder()
            .addType(R.layout.item_bill, Bill::class.java, BR.mainViewModel)
            .addType(R.layout.item_bill_title, User::class.java, BR.loginViewModel)
            .dataList(listOf(bill1, bill2, user1))
            .create()
        binder.recyclerBill.init(context, adapter)
    }

    override fun iniData() {
        Loger.d("iniData")
    }
}