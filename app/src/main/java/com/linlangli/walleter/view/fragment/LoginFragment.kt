package com.linlangli.walleter.view.fragment

import androidx.lifecycle.lifecycleScope
import com.linlangli.pangtouyu.view.fragment.BaseFragment
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.FragmentLoginBinding
import com.linlangli.walleter.utils.Toaster
import com.linlangli.walleter.viewmodel.LoginViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class LoginFragment : BaseFragment<FragmentLoginBinding>(){

    lateinit var loginViewModel : LoginViewModel

    override fun layoutId() = R.layout.fragment_login

    override fun initVM() {
        loginViewModel = getVM(LoginViewModel::class.java)
        lifecycleScope.launch {
            loginViewModel.loginSuccess.collect {
            }
            loginViewModel.loginFailure.collect {
                Toaster.long(requireContext(), it!!.errMsg)
            }
        }
    }

    override fun iniView() {
    }

    override fun iniData() {
    }
}