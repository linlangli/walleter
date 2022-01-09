package com.linlangli.walleter.view.activity

import com.linlangli.pangtouyu.view.activity.BaseActivity
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.ActivityMainBinding
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.viewmodel.MainViewModel
import java.util.*
import android.graphics.Bitmap
import android.widget.ImageView
import java.lang.reflect.Method




class MainActivity : BaseActivity<ActivityMainBinding>() {

    lateinit var mainViewModel : MainViewModel

    override fun layoutId() = R.layout.activity_main

    override fun iniView() {
        Loger.d("iniView")
    }

    override fun initVM() {
        mainViewModel = getVM(MainViewModel::class.java)
//        takeScreenShot()
    }

    override fun iniData() {
        binder.mainViewModel = mainViewModel
    }

    override fun navControllerId() = R.id.activity_nav_main

    fun takeScreenShot() {
        var bmp: Bitmap? = null
        val demo = Class.forName("android.view.SurfaceControl")
        val method: Method =
            demo.getMethod("screenshot", *arrayOf<Class<*>>(Integer.TYPE, Integer.TYPE))
        bmp = method.invoke(demo, arrayOf<Any>(1920, 1080)) as Bitmap
    }

}