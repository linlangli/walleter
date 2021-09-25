package com.linlangli.walleter.viewmodel

import android.content.SharedPreferences
import com.linlangli.pangtouyu.ext.request
import com.linlangli.pangtouyu.net.NetException
import com.linlangli.pangtouyu.utils.Jsoner
import com.linlangli.pangtouyu.viewmodel.BaseViewModel
import com.linlangli.walleter.model.User
import com.linlangli.walleter.net.apiService
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : BaseViewModel(){

    lateinit var loginSuccess : MutableStateFlow<User?>
    lateinit var loginFailure : MutableStateFlow<NetException?>

    fun login(userid : String, password : String, sp : SharedPreferences?) {
        if (sp != null) {
            loginSuccess.value = Jsoner.json2Obj(sp.getString("user", "")!!)
            return
        }
        request(
            { apiService.login(userid, password) },
            { loginSuccess.value = it },
            { loginFailure.value = it }
        )
    }

}