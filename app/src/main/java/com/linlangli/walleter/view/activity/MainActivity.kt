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
        Loger.d("iniView")
    }

    override fun initVM() {
        mainViewModel = getVM(MainViewModel::class.java)
    }

    override fun iniData() {
        binder.mainViewModel = mainViewModel
    }

    override fun navControllerId() = R.id.activity_nav_main

}