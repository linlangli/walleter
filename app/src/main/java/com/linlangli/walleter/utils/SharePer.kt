package com.linlangli.walleter.utils

import android.content.Context
import android.content.SharedPreferences

object SharePer {

    fun <T>set(context : Context, name : String, content : Map<String, T>) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        for(key in content.keys) {
            when {
                content[key] is String -> {
                    editor.putString(key, content[key] as String)
                }
                content[key] is Int -> {
                    editor.putInt(key, content[key] as Int)
                }
                content[key] is Boolean -> {
                    editor.putBoolean(key, content[key] as Boolean)
                }
                content[key] is Long -> {
                    editor.putLong(key, content[key] as Long)
                }
                content[key] is Float -> {
                    editor.putFloat(key, content[key] as Float)
                }
            }
        }
        editor.apply()
    }

    fun clear(context : Context, name : String) {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences(name, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }

}