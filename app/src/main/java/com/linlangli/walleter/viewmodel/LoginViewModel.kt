package com.linlangli.walleter.viewmodel

import android.content.SharedPreferences
import com.google.gson.Gson
import com.linlangli.pangtouyu.ext.request
import com.linlangli.pangtouyu.utils.Jsoner
import com.linlangli.pangtouyu.utils.SharePer
import com.linlangli.pangtouyu.viewmodel.BaseViewModel
import com.linlangli.walleter.model.User
import com.linlangli.walleter.net.NetApi
import com.linlangli.walleter.net.apiService
import com.linlangli.walleter.utils.Loger
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : BaseViewModel(){

    lateinit var userFlow : MutableStateFlow<User>

    fun login(userid : String, password : String, sp : SharedPreferences) {
//        var user : User
//        if (sp != null) {
//            user = Jsoner.json2Obj<User>(sp.getString("user", "")!!)
//        } else {
//            user = request()
//        }
//        userFlow.value = user
    }

}