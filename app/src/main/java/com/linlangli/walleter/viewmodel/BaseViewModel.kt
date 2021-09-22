package com.linlangli.walleter.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel :ViewModel() {

    val loadingChange: UiLoadingChange by lazy { UiLoadingChange() }

    inner class UiLoadingChange {
        //显示加载框
        val showDialog by lazy { MutableStateFlow<String>("正在加载...") }
        //隐藏
        val dismissDialog by lazy { MutableStateFlow<Boolean>(true) }
    }
}