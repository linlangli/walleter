package com.linlangli.walleter.viewmodel

import android.content.SharedPreferences
import com.linlangli.pangtouyu.ext.request
import com.linlangli.pangtouyu.net.NetException
import com.linlangli.pangtouyu.utils.Jsoner
import com.linlangli.pangtouyu.viewmodel.BaseViewModel
import com.linlangli.walleter.BuildConfig
import com.linlangli.walleter.model.User
import com.linlangli.walleter.net.apiService
import com.linlangli.walleter.utils.Loger
import kotlinx.coroutines.flow.MutableStateFlow

class LoginViewModel : BaseViewModel(){

    var loginSuccess : MutableStateFlow<User?> = MutableStateFlow(null)
    var loginFailure : MutableStateFlow<NetException?> = MutableStateFlow(null)

    var resultState : MutableStateFlow<String?> = MutableStateFlow(null)

    fun login(userid : String, password : String, sp : SharedPreferences?) {
        if (userid.isEmpty() || password.isEmpty()) {
            Loger.d("login", "账号或密码不能为空")
            resultState.value = "账号或密码不能为空"
            return
        }
        if(BuildConfig.IS_DEBUG) {
            loginSuccess.value = User("123", "123")
            return
        }
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

    fun register(loginPassword : String, loginPasswordAgain : String) {
        Loger.d(
            "login",
            "register",
            "loginPassword: $loginPassword | loginPasswordAgain: $loginPasswordAgain"
        )
        if (loginPassword != loginPasswordAgain) {
            resultState.value = "密码不一致，请重新输入"
            return
        }
        request(
            { apiService.register(loginPassword) },
            { loginSuccess.value = it },
            { loginFailure.value = it },
        )
    }

}