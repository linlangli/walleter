package com.linlangli.walleter.view.adapter

import android.content.Context
import android.util.SparseIntArray
import com.linlangli.pangtouyu.view.adapter.BaseAdapter
import com.linlangli.walleter.databinding.ItemMainBinding
import com.linlangli.walleter.utils.Loger

class MainAdapter(
    context : Context?,
    layoutId : Int,
    dataList : List<Statistics>)
    : BaseAdapter<Statistics, ItemMainBinding>(
        context,
        layoutId,
        dataList
    ) {
    override fun setViewType(layouts: SparseIntArray): SparseIntArray {
        return SparseIntArray()
    }

    override fun handle(
        holder: BaseViewHolder<ItemMainBinding>,
        position: Int,
        data: Statistics
    ) {
        Loger.e("测试","handle")
        holder.binder.textStatisticsContent.text = data.content.get()
    }
}