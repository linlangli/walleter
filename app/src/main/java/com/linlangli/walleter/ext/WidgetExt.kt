package com.linlangli.walleter.ext

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.linlangli.walleter.utils.Loger
import com.linlangli.walleter.view.fragment.*
import com.linlangli.walleter.viewmodel.MainViewModel

private val TAG = "WidgetExt"

fun ViewPager2.init(fragment: Fragment): ViewPager2 {
    //是否可滑动
    this.isUserInputEnabled = false
    this.offscreenPageLimit = 5
    //设置适配器
    adapter = object : FragmentStateAdapter(fragment) {
        override fun createFragment(position: Int): Fragment {
            when (position) {
                0 -> {
                    Loger.d(TAG,"createFragment | BillFragment")
                    return BillFragment()
                }
                1 -> {
                    Loger.d(TAG,"createFragment | ChartFragment")
                    return ChartFragment()
                }
                2 -> {
                    Loger.d(TAG,"createFragment | AssetsFragment")
                    return AssetsFragment()
                }
                3 -> {
                    Loger.d(TAG,"createFragment | MineFragment")
                    return MineFragment()
                }
                else -> {
                    Loger.d(TAG,"createFragment | else")
                    return BillFragment()
                }
            }
        }
        override fun getItemCount() = 4
    }
    return this
}