package com.linlangli.walleter.view.activity

import android.content.Intent
import com.linlangli.pangtouyu.view.activity.BaseActivity
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.ActivityStartBinding
import java.util.*

class LoginActivity : BaseActivity<ActivityStartBinding>() {
    override fun layoutId() = R.layout.activity_start

    override fun useDB() = true

    override fun iniView() {
        Timer().schedule(object: TimerTask(){
            override fun run() {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        },5000)
    }

    override fun iniData() {
    }

    override fun navControllerId() = -1
}