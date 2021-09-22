package com.linlangli.walleter.ext

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

fun RecyclerView.init(
    context : Context?,
    bindAdapter : RecyclerView.Adapter<*>) {
    setHasFixedSize(true)
    adapter = bindAdapter
    layoutManager = LinearLayoutManager(context)
}