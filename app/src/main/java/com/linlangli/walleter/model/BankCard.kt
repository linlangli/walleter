package com.linlangli.walleter.model

data class BankCard(
    val bankName : String,
    val number : String,
    val balance : Float,
) {
    override fun toString(): String {
        return "User | bankName: $bankName | number: $number | balance: $balance}"
    }
}
