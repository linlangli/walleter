package com.linlangli.pangtouyu.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.linlangli.walleter.utils.Loger

open class BaseAdapter (
    private val dataList : List<Any>,
    private val layoutMap : HashMap<Class<out Any>, Int>,
    private val brMap : HashMap<Class<out Any>, Int>,
    private val typeMap : HashMap<Class<out Any>, Int>,
    val listener : OnItemListener?
) : RecyclerView.Adapter<BaseAdapter.ViewHolder>() {
    private val TAG = "BaseAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Loger.d(TAG, "onCreateViewHolder | viewType: $viewType")
        val clazz = typeMap.entries.associate { (k, v) -> v to k }[viewType]
        val binding : ViewDataBinding =
            DataBindingUtil.inflate(LayoutInflater.from(parent.context),
                layoutMap[clazz]!!,
                parent,
                false
            )
        val holder = ViewHolder(binding.root)
        holder.binding = binding
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bean = dataList[position];
        val clazz = bean::class.java
        holder.binding.setVariable(brMap[clazz]!!, dataList[position])
        holder.binding.executePendingBindings()
        Loger.d(TAG, "onBindViewHolder | brMap: $brMap | typeMap: $typeMap | layoutMap: $layoutMap")
        listener?.itemListener(bean, holder.binding, position)
    }

    override fun getItemCount() : Int {
        Loger.d(TAG, "getItemCount | dataList.size: ${dataList.size}")
        return dataList.size
    }

    override fun getItemViewType(position: Int) : Int{
        val clazz = dataList[position]::class.java
        //检查未配置的类型
        if (!typeMap.containsKey(clazz)) {
            throw RuntimeException("DataType:" + clazz.simpleName + " not config!")
        }
        return typeMap[clazz]!!
    }


    class Builder {

        private val layoutMap = HashMap<Class<out Any>, Int>()
        private val brMap = HashMap<Class<out Any>, Int>()
        private val typeMap = HashMap<Class<out Any>, Int>()
        private var listData : List<Any> = listOf()
        private var viewType = 1
        var listener : OnItemListener? = null

        fun addType(layoutId: Int, dataType: Class<out Any>, br: Int) : Builder {
            layoutMap[dataType] = layoutId
            brMap[dataType] = br
            typeMap[dataType] = viewType
            viewType++
            return this
        }
        fun dataList(listData : List<Any>) : Builder {
            this.listData = listData
            return this
        }
        fun addItemListener(listener : OnItemListener) : Builder {
            this.listener = listener
            return this
        }
        fun create() : BaseAdapter {
            return BaseAdapter(listData, layoutMap, brMap, typeMap, listener)
        }
    }

    interface OnItemListener {
        fun itemListener(bean: Any?, binding: ViewDataBinding?, position: Int)
    }

    open class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding : ViewDataBinding
    }
}

