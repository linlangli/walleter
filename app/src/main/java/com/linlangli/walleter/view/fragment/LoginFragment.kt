package com.linlangli.walleter.view.fragment

import android.content.Context
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentLoginBinding
import com.linlangli.walleter.utils.Loger
import com.linlangli.pangtouyu.utils.Toaster
import com.linlangli.walleter.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<FragmentLoginBinding>(){

    lateinit var loginViewModel : LoginViewModel

    override fun layoutId() = R.layout.fragment_login

    override fun initVM() {
        loginViewModel = getVM(LoginViewModel::class.java)
    }

    override fun iniView() {
        binder.loginClickEvent = LoginClickEvent()
        binder.loginViewModel = loginViewModel
    }

    override fun iniData() {
        lifecycleScope.launch {
            loginViewModel.loginSuccess.collect {
                Loger.d("login", "loginSuccess change")
                it?.let {
                    nav(R.id.action_loginFragment_to_mainFragment)
                }
            }
        }
        lifecycleScope.launch {
            loginViewModel.resultState.collect {
                Loger.d("login", "resultState change")
                it?.let {
                    Toaster.long(requireContext(), it)
                }
            }
        }
        lifecycleScope.launch {
            loginViewModel.loginFailure.collect {
                Loger.d("login", "loginFailure change")
                it?.let {
                    Toaster.long(requireContext(), it.errMsg)
                }
            }
        }
    }

    inner class LoginClickEvent {
        private var registerState : Boolean = false
        fun login(view : View) {
            val userId = binder.editUser.text.toString()
            val password = binder.editPassword.text.toString()
            Loger.d("login", "userId: $userId | password: $password")
            if (registerState) {
                loginViewModel.register(userId, password)
            } else {
                loginViewModel.login(userId, password,
                    activity?.getSharedPreferences("login", Context.MODE_PRIVATE)
                )
            }
        }
        fun register(view : View) {
            if (registerState) {
                binder.editUser.hint = getString(R.string.user_id)
                binder.editPassword.hint = getString(R.string.user_password)
                binder.buttLogin.text = getString(R.string.login)
                binder.textRegister.text = getString(R.string.register)
                registerState = false
            } else {
                binder.editUser.hint = getString(R.string.login_password)
                binder.editPassword.hint = getString(R.string.login_password_again)
                binder.buttLogin.text = getString(R.string.register)
                binder.textRegister.text = getString(R.string.login)
                registerState = true
            }
        }
        // ???????????????????????????
        fun retrievePassword(view : View) {}
    }
}