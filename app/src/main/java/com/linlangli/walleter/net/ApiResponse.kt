package com.linlangli.walleter.net

data class ApiResponse<T>(val code : Int, val msg : String, val data : T) {
    fun isSuccess() = code == Status.SUCCESS.code
}