package com.Auty.Auty.Common

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(fragmentActivity: FragmentActivity, private val arr: ArrayList<Fragment>
) : FragmentStateAdapter(fragmentActivity){
    override fun getItemCount(): Int {
        return arr.size
    }
    override fun createFragment(position: Int): Fragment {
        return arr.get(position)
    }


}