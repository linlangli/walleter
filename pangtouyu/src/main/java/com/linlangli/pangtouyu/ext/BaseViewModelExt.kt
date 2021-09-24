package com.linlangli.pangtouyu.ext

import androidx.lifecycle.viewModelScope
import com.linlangli.pangtouyu.net.BaseResponse
import com.linlangli.pangtouyu.net.NetException
import com.linlangli.pangtouyu.viewmodel.BaseViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

fun <T> BaseViewModel.request(
    block: suspend () -> BaseResponse<T>,
    success: (T) -> Unit,
    error: (NetException) -> Unit = {},
    isShowDialog: Boolean = false,
    loadingMessage: String = "请求网络中..."
): Job {
    //如果需要弹窗 通知Activity/fragment弹窗
    return viewModelScope.launch {
        runCatching {
            if (isShowDialog) loadingChange.showDialog.value = loadingMessage
            //请求体
            block()
        }.onSuccess {
            //网络请求成功 关闭弹窗
            loadingChange.dismissDialog.value = false
            runCatching {
                //校验请求结果码是否正确，不正确会抛出异常走下面的onFailure
                executeResponse(it) { t -> success(t) }
            }.onFailure { e ->
                //打印错误消息
            }
        }.onFailure {
            //网络请求异常 关闭弹窗
            loadingChange.dismissDialog.value = false
            //打印错误消息
        }
    }
}

suspend fun <T> executeResponse(
    response: BaseResponse<T>,
    success: suspend CoroutineScope.(T) -> Unit
) {
    coroutineScope {
        when {
            response.isSuccess() -> {
                success(response.getResponseData())
            }
            else -> {
                throw NetException(
                    response.getResponseCode(),
                    response.getResponseMsg(),
                )
            }
        }
    }
}
