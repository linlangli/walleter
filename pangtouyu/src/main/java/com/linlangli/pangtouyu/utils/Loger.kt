package com.linlangli.walleter.utils

import android.util.Log

object Loger {

    fun e(msg: String) {
        Log.e(Exception().stackTrace[1].className, msg)
    }

    fun e(tag: String, msg: String) {
        Log.e(tag, msg)
    }

    fun e(tag: String, msg: String, tr: Throwable) {
        Log.e(tag, msg, tr)
    }

    fun e(tag: String, tr: Throwable) {
        Log.e(tag, "", tr)
    }

    fun d(msg: String) {
        Log.d(Exception().stackTrace[1].className, msg)
    }

    fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }

    fun d(tag: String, method : String,  msg: String) {
        Log.e("[$tag] 🚀", "[$method] 🚗 | $msg")
    }
}