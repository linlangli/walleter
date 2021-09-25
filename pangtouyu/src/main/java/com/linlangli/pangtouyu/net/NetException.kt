package com.linlangli.pangtouyu.net

import android.net.ParseException
import com.google.gson.JsonParseException
import com.google.gson.stream.MalformedJsonException
import com.linlangli.walleter.utils.Loger
import org.json.JSONException
import retrofit2.HttpException
import java.net.ConnectException

class NetException : Exception {

    companion object {
        fun getNetException(e : Throwable?) : NetException {
            val ex: NetException
            e?.let {
                when (it) {
                    is HttpException -> {
                        ex = NetException(ErrorCode.NETWORK_ERROR,e)
                        return ex
                    }
                    is JsonParseException, is JSONException, is ParseException, is MalformedJsonException -> {
                        ex = NetException(ErrorCode.PARSE_ERROR,e)
                        return ex
                    }
                    is ConnectException -> {
                        ex = NetException(ErrorCode.NETWORK_ERROR,e)
                        return ex
                    }
                    is javax.net.ssl.SSLException -> {
                        ex = NetException(ErrorCode.SSL_ERROR,e)
                        return ex
                    }
                    is java.net.SocketTimeoutException -> {
                        ex = NetException(ErrorCode.TIMEOUT_ERROR,e)
                        return ex
                    }
                    is java.net.UnknownHostException -> {
                        ex = NetException(ErrorCode.TIMEOUT_ERROR,e)
                        return ex
                    }
                    is NetException -> return it

                    else -> {
                        ex = NetException(ErrorCode.UNKNOWN,e)
                        return ex
                    }
                }
            }
            ex = NetException(ErrorCode.UNKNOWN,e)
            return ex
        }
        fun getNetException(errCode : Int, errMsg : String) : NetException {
            return NetException(errCode, errMsg)
        }
    }

    var errMsg: String //错误消息
    var errCode: Int //错误码
    var throwable: Throwable? = null

   private constructor(
       errCode: Int = -1,
       errMsg: String = "请求失败，请稍后再试",
       throwable: Throwable? = null
   ) : super(errMsg) {
        this.errMsg = errMsg
        this.errCode = errCode
       Loger.e("net", "request failure | errCode: $errCode | errMsg: $errMsg")
        this.throwable = throwable
    }

    private constructor(errorCode : ErrorCode, e: Throwable?) {
        errCode = errorCode.getKey()
        errMsg = errorCode.getValue()
        Loger.e("net", "request failure | errCode: $errCode | errMsg: $errMsg")
        throwable = e
    }
}