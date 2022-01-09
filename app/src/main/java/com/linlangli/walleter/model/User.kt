package com.linlangli.walleter.model

data class User(
    val userid : String,
    val password : String,
    val username : String = "胖头鱼",
    val outlay : Float = 0f,
    val income : Float = 0f,
    val balance : Float = 0f,
    val bankCard: List<BankCard>? = null
) {
    override fun toString(): String {
        return "User { userid: $userid | password: $password | username: $username | outlay: $outlay | income: $income | balance: $balance | bankCard: ${bankCard.toString()} }"
    }
}
