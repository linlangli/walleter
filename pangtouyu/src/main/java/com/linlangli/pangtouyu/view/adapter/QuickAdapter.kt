package com.linlangli.pangtouyu.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

open class QuickAdapter (
    private val itemList : List<Any>,
    private val itemBr : Int,
    private val variablesMap : HashMap<Int, Any>,
    private var itemType : ItemTypeSetter
) : RecyclerView.Adapter<QuickAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ViewDataBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
            )
        val holder = ViewHolder(binding.root)
        holder.binding = binding
        return holder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.setVariable(itemBr, itemList[position])
        variablesMap.forEach {
            holder.binding.setVariable(it.key, it.value)
        }
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = itemList.size

    override fun getItemViewType(position: Int) : Int = itemType.setItemType(position)


    class Builder {

        private var variablesMap = HashMap<Int, Any>()
        private lateinit var itemTypeSetter : ItemTypeSetter
        private var itemList : List<Any> = listOf()
        private var itemBR : Int = -1

        fun addItems(itemBR : Int, itemList : List<Any>) : Builder {
            this.itemBR = itemBR
            this.itemList = itemList
            return this
        }
        fun addVariable(variableBR : Int, variable : Any) : Builder {
            variablesMap[variableBR] = variable
            return this
        }
        fun addItemTypeSetter(itemTypeSetter: ItemTypeSetter) : Builder {
            this.itemTypeSetter = itemTypeSetter
            return this
        }
        fun create() : QuickAdapter {
            return QuickAdapter(itemList, itemBR, variablesMap, itemTypeSetter)
        }
    }

    interface ItemTypeSetter {
        fun setItemType(position: Int) : Int
    }

    open class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        lateinit var binding : ViewDataBinding
    }
}

