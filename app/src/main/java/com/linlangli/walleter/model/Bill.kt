package com.linlangli.walleter.model

data class Bill(
    val date : String,
    val userid : String,
    val name : String,
    val desc : String,
    val amount : Float,
) {
    override fun toString(): String {
        return "Bill { userid: $userid | date: $date | name: $name | desc: $desc | amount: $amount }"
    }
}