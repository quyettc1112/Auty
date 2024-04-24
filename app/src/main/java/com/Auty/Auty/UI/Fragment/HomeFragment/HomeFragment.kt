package com.Auty.Auty.UI.Fragment.HomeFragment

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.Auty.Auty.R
import com.Auty.Auty.UI.Activity.authen.LoginActivity
import com.Auty.Auty.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModels()
    private lateinit var  binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        return binding.root
    }
}