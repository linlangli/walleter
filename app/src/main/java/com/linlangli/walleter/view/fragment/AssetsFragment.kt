package com.linlangli.walleter.view.fragment

import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentAssetsBinding
import com.linlangli.walleter.utils.Loger

class AssetsFragment : BaseFragment<FragmentAssetsBinding>(){
    override fun layoutId() = R.layout.fragment_assets

    override fun initVM() {
    }

    override fun iniView() {
    }

    override fun iniData() {
        Loger.e("AssetsFragment")
    }
}