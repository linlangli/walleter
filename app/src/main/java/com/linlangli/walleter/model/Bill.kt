package com.linlangli.walleter.model

import com.linlangli.pangtouyu.view.adapter.BaseItem
import com.linlangli.walleter.R

data class Bill(
    val date : String,
    val userid : String,
    val name : String,
    val desc : String,
    val amount : Float,
    val recyclerLayout : Int = R.layout.item_bill
) : BaseItem(recyclerLayout) {
    override fun toString(): String {
        return "User | userid: $userid | date: $date | name: $name | desc: $desc | amount: $amount}"
    }
}