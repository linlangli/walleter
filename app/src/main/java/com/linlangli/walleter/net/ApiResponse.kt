package com.linlangli.walleter.net

import com.linlangli.pangtouyu.net.BaseResponse

data class ApiResponse<T>(
    val errCode: Int,
    val errMsg: String,
    val data: T
) : BaseResponse<T>() {

    override fun isSuccess() = errCode == 0

    override fun getResponseCode() = errCode

    override fun getResponseData() = data

    override fun getResponseMsg() = errMsg

}