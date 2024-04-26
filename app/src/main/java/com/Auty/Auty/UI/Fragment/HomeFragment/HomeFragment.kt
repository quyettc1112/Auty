package com.Auty.Auty.UI.Fragment.HomeFragment

import android.content.Intent
import androidx.fragment.app.viewModels
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.Auty.Auty.AppConfig.Constant.Constant
import com.Auty.Auty.Common.CourseMainAdapter
import com.Auty.Auty.Common.RecommendSliderAdapter
import com.Auty.Auty.R
import com.Auty.Auty.UI.Activity.authen.LoginActivity
import com.Auty.Auty.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {


    private val viewModel: HomeViewModel by viewModels()
    private lateinit var  binding: FragmentHomeBinding


    private lateinit var handler: Handler

    // List CourseRecomend
    private var courseRecomendAdapter =  RecommendSliderAdapter (
        listOf(
            RecommendSliderAdapter.CourseRecomment(
                title = "Cách nhận biết trẻ bị tự kỷ",
                image = R.drawable.ic_material_recommend,
                rating = 4.5,
                reviewNumder = 4242
            ),
            RecommendSliderAdapter.CourseRecomment(
                title = "Biểu hiện của trẻ bị tự kỷ theo các mức độ",
                image = R.drawable.ic_material_aytism,
                rating = 4.0,
                reviewNumder = 4242
            ),
            RecommendSliderAdapter.CourseRecomment(
                title = "Độ tuổi dễ bị tổn thương sâu sắc về tình cảm",
                image = R.drawable.ic_materaial_parent,
                rating = 3.5,
                reviewNumder = 4242
            ),
        )
    )

    private lateinit var courseMainAdapter: CourseMainAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        courseMainAdapter = CourseMainAdapter(Constant.getListCourse())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        setUpSliderCourseRecomend()
        setUpCourseMainRecycleView()
        onPageChangeCallBack()
        onItemCourseRecClick()
        return binding.root
    }
    private fun onPageChangeCallBack() {
        binding.viewPagerCourseRecomend.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable, 4000)
            }
        })
    }
    private fun setUpSliderCourseRecomend() {
        binding.viewPagerCourseRecomend.let {
            it.adapter = courseRecomendAdapter
            it.offscreenPageLimit  =3
            it.clipToPadding= false
            it.clipChildren= false
            it.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_ALWAYS
        }
        handler = Handler(Looper.myLooper()!!)
    }
    private val runnable = Runnable {
        binding.viewPagerCourseRecomend.let {
            val currentItem = binding.viewPagerCourseRecomend.currentItem
            val nextItem = if (currentItem < courseRecomendAdapter.itemCount - 1) currentItem + 1 else 0
            binding.viewPagerCourseRecomend.setCurrentItem(nextItem, true)
        }
    }
    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }
    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable, 4000)
    }
    private fun onItemCourseRecClick() {
        courseRecomendAdapter.onItemClick = {
            Intent(requireActivity(), LoginActivity::class.java).also {
                startActivity(it)
            }

        }
    }

    private fun setUpCourseMainRecycleView(){
        binding.rvCourse.adapter = courseMainAdapter
    }
}