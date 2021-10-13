package com.linlangli.walleter.view.fragment

import android.view.View
import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentMainBinding
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.viewmodel.MainViewModel


class MainFragment : BaseFragment<FragmentMainBinding>() {

    lateinit var mainViewModel : MainViewModel

    override fun layoutId() = R.layout.fragment_main

    override fun initVM() {
        mainViewModel = getVM(MainViewModel::class.java)
    }

    override fun iniView() {
    }

    override fun iniData() {
        binder.mainViewModel = mainViewModel
    }


    override fun navControllerId() = -1
}