package com.linlangli.walleter.utils

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

object NaVer {

    fun Fragment.controller(): NavController {
        return NavHostFragment.findNavController(this)
    }

    fun controller(view: View): NavController {
        return Navigation.findNavController(view)
    }

    private var lastNavTime = 0L

    fun NavController.nav(resId: Int, bundle: Bundle? = null, interval: Long = 500) {
        val currentTime = System.currentTimeMillis()
        if (currentTime >= lastNavTime + interval) {
            lastNavTime = currentTime
            try {
                navigate(resId, bundle)
            }catch (ignore:Exception){
            }
        }
    }
}