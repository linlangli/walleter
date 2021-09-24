package com.linlangli.pangtouyu.utils

import com.google.gson.Gson
import com.linlangli.walleter.utils.Loger

object Jsoner {

    val gson = Gson()

    inline fun <reified T>json2Obj(json : String) : T {
        Loger.d("json", json)
        val t = gson.fromJson(json, T::class.java)
        Loger.d("model", t.toString())
        return t
    }
}