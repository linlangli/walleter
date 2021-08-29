package com.linlangli.walleter.view.activity

import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.ActivityMainBinding
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.viewmodal.MainViewModal

class MainActivity : BaseActivity<ActivityMainBinding>() {

    val mResultLaunch = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) {
        Loger.e("测试", "MainActivity_resultCode: ${it.resultCode}")
    }

    lateinit var mainViewModal : MainViewModal

    override fun layoutId() = R.layout.activity_main

    override fun useDB() = true

    override fun iniView() {
        Loger.e("🚀")
        binder.clickEvent = ClickEvent()
        mainViewModal.selected.set("main")
        nav(R.id.toMainFragment)
    }

    override fun iniData() {
        mainViewModal = getVM(MainViewModal::class.java)
        mainViewModal.selected.set("main")
        binder.mainViewModal = mainViewModal
    }

    override fun navControllerId() = R.id.fragment_nav

    inner class ClickEvent {
        private var flag = -1
        fun bottomBar(view : View) {
            if (view.id == flag) return
            flag = view.id
            when(view.id) {
                R.id.view_main -> {
                    Loger.e("layout_bottom_bar_main")
                    mainViewModal.selected.set("main")
                    nav(R.id.toMainFragment)
                }
                R.id.view_chart -> {
                    Loger.e("layout_bottom_bar_chart")
                    mainViewModal.selected.set("chart")
                    nav(R.id.toChartFragment)
                }
                R.id.view_assets ->  {
                    Loger.e("layout_bottom_bar_asserts")
                    mainViewModal.selected.set("assets")
                    nav(R.id.toAssertsFragment)
                }
                R.id.view_plan -> {
                    Loger.e("layout_bottom_bar_clock")
                    mainViewModal.selected.set("plan")
                    nav(R.id.toPlanFragment)
                }
            }
        }
    }
}