package com.linlangli.walleter.net

enum class ErrorCode(private val code: Int, private val err: String) {

    /**
     * 未知错误
     */
    UNKNOWN(1000, "请求失败，请稍后再试"),
    /**
     * 解析错误
     */
    PARSE_ERRORCode(1001, "解析错误，请稍后再试"),
    /**
     * 网络错误
     */
    NETWORK_ERRORCode(1002, "网络连接错误，请稍后重试"),

    /**
     * 证书出错
     */
    SSL_ERRORCode(1004, "证书出错，请稍后再试"),

    /**
     * 连接超时
     */
    TIMEOUT_ERRORCode(1006, "网络连接超时，请稍后重试");

    fun getValue(): String {
        return err
    }

    fun getKey(): Int {
        return code
    }

}