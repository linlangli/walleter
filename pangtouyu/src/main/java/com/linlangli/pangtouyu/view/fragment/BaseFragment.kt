package com.linlangli.pangtouyu.view.fragment

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.linlangli.pangtouyu.viewmodel.BaseViewModel

abstract class BaseFragment<DB : ViewDataBinding> : Fragment() {

    lateinit var binder : DB
    private lateinit var navController: NavController

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
        val navControllerId = navControllerId()
        if (navControllerId != -1) {
            navController = Navigation.findNavController(activity as Activity, navControllerId())
        }
        initVM()
        iniData()
        iniView()
    }

    abstract fun layoutId() : Int

    abstract fun initVM()

    abstract fun iniView()

    abstract fun iniData()

    abstract fun navControllerId() : Int

    fun <T : BaseViewModel> getVM(clazz : Class<T>) : T
            = ViewModelProvider(this).get(clazz)

    fun nav(id : Int){
        try {
            navController.navigate(id)
        } catch (ignore:Exception) {}
    }
}