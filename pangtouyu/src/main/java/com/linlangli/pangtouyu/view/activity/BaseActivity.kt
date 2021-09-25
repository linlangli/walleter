package com.linlangli.pangtouyu.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation.findNavController
import com.linlangli.pangtouyu.utils.SharePer
import com.linlangli.pangtouyu.viewmodel.BaseViewModel


abstract class BaseActivity<DB : ViewDataBinding> : AppCompatActivity() {

    lateinit var binder: DB

    private lateinit var mainNvController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (useDB()) {
            binder = DataBindingUtil.setContentView(this, layoutId())
            setContentView(binder.root)
        } else {
            setContentView(layoutId())
        }
        val navControllerId = navControllerId()
        if (navControllerId != -1) {
            mainNvController = findNavController(this, navControllerId())
        }
        iniData()
        iniView()
        SharePer.set(this, "name", mapOf("1" to "test", "ted" to "test"))
    }

    abstract fun layoutId() : Int

    abstract fun useDB() : Boolean

    abstract fun iniView()

    abstract fun iniData()

    abstract fun navControllerId() : Int

    fun nav(id : Int){
        try {
            mainNvController.navigate(id)
        } catch (ignore:Exception) {}
    }

    fun <T : BaseViewModel> getVM(clazz : Class<T>) : T
        = ViewModelProvider(this).get(clazz)

}