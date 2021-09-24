package com.linlangli.walleter.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.linlangli.pangtouyu.viewmodel.BaseViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

    var selected = ObservableField<String>()

    fun test() {
        GlobalScope.launch {

        }
    }

}