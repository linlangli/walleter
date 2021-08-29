package com.linlangli.walleter.net

enum class Status(val code : Int, val msg : String) {
    SUCCESS(200, "请求成功"),
    ERROR_SERVER(500, "服务器错误"),
    LOADING(0, "正在请求")
}