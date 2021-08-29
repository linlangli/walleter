package com.linlangli.walleter

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.ProcessLifecycleOwner

class BaseApp : Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }

    fun appStatus(lifecycleObserver : LifecycleObserver) {
        ProcessLifecycleOwner.get().lifecycle.addObserver(lifecycleObserver)
    }
}