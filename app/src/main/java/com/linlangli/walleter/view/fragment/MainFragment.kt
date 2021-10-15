package com.linlangli.walleter.view.fragment

import android.view.View
import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentMainBinding
import com.linlangli.walleter.ext.init
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.viewmodel.MainViewModel


class MainFragment : BaseFragment<FragmentMainBinding>() {

    lateinit var mainViewModel : MainViewModel

    override fun layoutId() = R.layout.fragment_main

    override fun initVM() {
        mainViewModel = getVM(MainViewModel::class.java)
    }

    override fun iniData() {
        binder.mainViewModel = mainViewModel
        binder.mainClickEvent = MainClickEvent()
    }

    override fun iniView() {
        Loger.d("iniView")
        mainViewModel.selected.set("bill")
        binder.viewpage2Main.init(this)
    }

    inner class MainClickEvent {
        private var flag = -1
        fun bottomBar(view : View) {
            if (view.id == flag) return
            flag = view.id
            when(view.id) {
                R.id.view_bill -> {
                    Loger.d("view_bill")
                    mainViewModel.selected.set("bill")
                    binder.viewpage2Main.setCurrentItem(0, false)
                }
                R.id.view_chart -> {
                    Loger.d("view_chart")
                    mainViewModel.selected.set("chart")
                    binder.viewpage2Main.setCurrentItem(1, false)
                }
                R.id.view_assets ->  {
                    Loger.d("view_assets")
                    mainViewModel.selected.set("assets")
                    binder.viewpage2Main.setCurrentItem(2, false)
                }
                R.id.view_mine -> {
                    Loger.d("view_mine")
                    mainViewModel.selected.set("mine")
                    binder.viewpage2Main.setCurrentItem(3, false)
                }
            }
        }
    }

}