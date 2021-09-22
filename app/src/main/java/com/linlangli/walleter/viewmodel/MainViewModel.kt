package com.linlangli.walleter.viewmodel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.linlangli.walleter.model.Bill
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

    var selected = ObservableField<String>()

    lateinit var billList : MutableLiveData<Bill>

    fun test() {
        GlobalScope.launch {

        }
    }

}