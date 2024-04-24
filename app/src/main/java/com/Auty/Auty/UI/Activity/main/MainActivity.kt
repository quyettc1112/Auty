package com.Auty.Auty.UI.Activity.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.Auty.Auty.AppConfig.BaseConfig.BaseActivity
import com.Auty.Auty.Common.FragmentAdapter
import com.Auty.Auty.R
import com.Auty.Auty.UI.Activity.authen.LoginActivity
import com.Auty.Auty.UI.Fragment.CartFragment.CartFragment
import com.Auty.Auty.UI.Fragment.CourseFragment.CourseFragment
import com.Auty.Auty.UI.Fragment.HomeFragment.HomeFragment
import com.Auty.Auty.UI.Fragment.ProfileFragment.ProfileFragment
import com.Auty.Auty.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var FragmentAdapter: FragmentAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpFragmentWithViewPager()
        setUpBottomNav()
    }
    private fun setUpFragmentWithViewPager() {
        val listFragment: ArrayList<Fragment> = ArrayList()
        listFragment.add(HomeFragment())
        listFragment.add(CourseFragment())
        listFragment.add(CartFragment())
        listFragment.add(ProfileFragment())

        FragmentAdapter = FragmentAdapter(this, listFragment)
        binding.vp2Main.adapter = FragmentAdapter
        binding.vp2Main.offscreenPageLimit = 4

        // Settup change listener
        binding.vp2Main.registerOnPageChangeCallback(object: ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                binding.niceBottomNav.setActiveItem(position)
                super.onPageSelected(position)
            }
        })
    }
    private fun setUpBottomNav(){
        binding.niceBottomNav.onItemSelected = {idFragemnt ->
            binding.vp2Main.setCurrentItem(idFragemnt, true)
        }

    }
}