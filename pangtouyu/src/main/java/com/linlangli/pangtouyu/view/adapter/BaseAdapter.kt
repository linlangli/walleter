package com.linlangli.pangtouyu.view.adapter

import android.content.Context
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.linlangli.walleter.utils.Loger

abstract class BaseAdapter<T, D : ViewDataBinding>(
    private val context: Context?,
    private val layoutId: Int,
    private val dataList: List<T>
) : RecyclerView.Adapter<BaseAdapter.BaseViewHolder<D>>() {
    private val TAG = "BaseAdapter"
    private var layouts = SparseIntArray()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<D> {
        val binding = DataBindingUtil.inflate<D>(
            LayoutInflater.from(parent.context), layoutId, parent, false
        )
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<D>, position: Int) {
        handle(holder, position, dataList[position])
    }

    override fun getItemCount() : Int {
        Loger.e(TAG, "getItemCount | dataList.size: ${dataList.size}")
        return dataList.size
    }

    override fun getItemViewType(position: Int) : Int{
        Loger.e(TAG, "getItemViewType | position: $position")
        layouts = setViewType(layouts);
        if (layouts.size() == 0) {
            return layoutId
        }
        return layouts[position]
    }

    abstract fun setViewType(layouts : SparseIntArray) : SparseIntArray

    abstract fun handle(holder : BaseViewHolder<D>, position : Int, data : T)

    open class BaseViewHolder<D : ViewDataBinding>(open val binder : D) : RecyclerView.ViewHolder(binder.root)
}
