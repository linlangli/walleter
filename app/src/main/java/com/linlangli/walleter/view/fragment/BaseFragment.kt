package com.linlangli.walleter.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.linlangli.walleter.viewmodal.BaseViewModal

abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {

    lateinit var binder : DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binder = DataBindingUtil.inflate<DB>(inflater, layoutId(), container, false)
        return binder.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initVM()
        iniData()
        iniView()
    }

    abstract fun layoutId() : Int

    abstract fun initVM()

    abstract fun iniView()

    abstract fun iniData()

    fun <T : BaseViewModal> getVM(clazz : Class<T>) : T
            = ViewModelProvider(this).get(clazz)
}