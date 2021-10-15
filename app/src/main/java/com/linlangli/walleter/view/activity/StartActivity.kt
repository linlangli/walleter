package com.linlangli.walleter.view.activity

import android.content.Intent
import com.linlangli.pangtouyu.view.activity.BaseActivity
import com.linlangli.walleter.R
import com.linlangli.walleter.databinding.ActivityStartBinding
import com.linlangli.walleter.utils.Loger
import java.util.*

class StartActivity : BaseActivity<ActivityStartBinding>() {
    override fun layoutId() = R.layout.activity_start

    override fun iniView() {
        Timer().schedule(object: TimerTask(){
            override fun run() {
                Loger.e("schedule")
                startActivity(Intent(this@StartActivity, MainActivity::class.java))
                finish()
            }
        },3000)
    }

    override fun iniData() {
    }

    override fun navControllerId() = -1

    override fun initVM(){}
}