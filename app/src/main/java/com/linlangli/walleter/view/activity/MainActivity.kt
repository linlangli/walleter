package com.linlangli.walleter.view.activity

import android.view.View
import com.linlangli.pangtouyu.view.activity.BaseActivity
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.ActivityMainBinding
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.viewmodel.MainViewModel

class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var mainViewModel : MainViewModel

    override fun layoutId() = R.layout.activity_main

    override fun iniView() {
        Loger.e("🚀")
    }

    override fun initVM() {
        mainViewModel = getVM(MainViewModel::class.java)
    }

    override fun iniData() {
        mainViewModel.selected.set("bill")
        binder.mainClickEvent = MainClickEvent()
        binder.mainViewModel = mainViewModel
    }

    override fun navControllerId() = R.id.fragment_nav_main

    inner class MainClickEvent {
        private var flag = -1
        fun bottomBar(view : View) {
            if (view.id == flag) return
            flag = view.id
            when(view.id) {
                R.id.view_bill -> {
                    Loger.e("layout_bottom_bar_main")
                    mainViewModel.selected.set("bill")
                    nav(R.id.mainFragment2BillFragment)
                }
                R.id.view_chart -> {
                    Loger.e("layout_bottom_bar_chart")
                    mainViewModel.selected.set("chart")
                    nav(R.id.mainFragment2ChartFragment)
                }
                R.id.view_assets ->  {
                    Loger.e("layout_bottom_bar_asserts")
                    mainViewModel.selected.set("assets")
                    nav(R.id.mainFragment2AssertsFragment)
                }
                R.id.view_plan -> {
                    Loger.e("layout_bottom_bar_clock")
                    mainViewModel.selected.set("plan")
                    nav(R.id.mainFragment2PlanFragment)
                }
            }
        }
    }

}