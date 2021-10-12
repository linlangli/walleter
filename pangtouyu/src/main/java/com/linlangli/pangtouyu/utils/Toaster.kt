package com.linlangli.pangtouyu.utils

import android.content.Context
import android.widget.Toast

object Toaster {

    fun long(context : Context, message : String) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    fun short(context : Context, message : String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    fun show(context : Context, message : String, duration : Int) {
        Toast.makeText(context, message, duration).show()
    }
}