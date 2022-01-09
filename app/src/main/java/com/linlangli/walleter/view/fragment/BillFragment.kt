package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.ext.init
import com.linlangli.pangtouyu.view.adapter.QuickAdapter.*
import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.BR
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentBillBinding
import com.linlangli.walleter.model.Bill
import com.linlangli.walleter.model.User
import com.linlangli.walleter.utils.Loger

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
            "2022年",
            "e3333",
            "fedef",
            "我的fef",
            123f,
        )

        val user1 = User(
            "userid",
            "222"
        )

        val bills = listOf<Bill>(bill1, bill2, bill2, bill2, bill2, bill1)

        val adapter = Builder()
            .addItems(BR.bill, bills)
            .addVariable(BR.user, user1)
            .addVariable(BR.bill, bill2)
            .addItemTypeSetter(object : ItemTypeSetter {
                override fun setItemType(position: Int): Int {
                    if ( position < bills.size &&
                        (position == 0 ||
                        bills[position].date != bills[position - 1].date)
                    ) {
                        return R.layout.item_bill_title
                    }
                    return R.layout.item_bill
                }
            })
            .create()
        binder.recyclerBill.init(context, adapter)
    }

    override fun iniData() {
        Loger.d("iniData")
    }
}