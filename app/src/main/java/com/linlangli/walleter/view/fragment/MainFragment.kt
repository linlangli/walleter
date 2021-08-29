package com.linlangli.walleter.view.fragment

import androidx.activity.result.contract.ActivityResultContracts
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentMainBinding
import com.linlangli.walleter.modal.Statistics
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.view.adapter.MainAdapter
import com.linlangli.walleter.view.adapter.init


class MainFragment : BaseFragment<FragmentMainBinding>() {

    val mResultLaunch = registerForActivityResult(ActivityResultContracts.StartActivityForResult()
    ) {
        Loger.e("测试", "BankCardFragment_resultCode: ${it.resultCode}")
    }

    override fun layoutId() = R.layout.fragment_main

    override fun initVM() {
    }

    override fun iniView() {
    }

    override fun iniData() {
        val statistics = Statistics()
        statistics.content.set("100")
        val data = listOf(statistics)
        binder.recyclerMain.init(
            context,
            MainAdapter(
                context,
                R.layout.item_main,
                data
            )
        )
    }

}