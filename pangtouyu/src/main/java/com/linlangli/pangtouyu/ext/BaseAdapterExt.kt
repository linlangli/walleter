package com.linlangli.pangtouyu.ext

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.init(
    context : Context?,
    bindAdapter : RecyclerView.Adapter<*>) {
    adapter = bindAdapter
    layoutManager = LinearLayoutManager(context)
}