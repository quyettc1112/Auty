package com.Auty.Auty.Common

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Auty.Auty.R

class IntroSliderAdapter(private val introSlides: List<IntroSlide>) :
    RecyclerView.Adapter<IntroSliderAdapter.IntroSliderViewHolder>() {
    inner class IntroSliderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val textTitle = view.findViewById<TextView>(R.id.intro_title)
        private val textDescription = view.findViewById<TextView>(R.id.intro_description)
        private val image = view.findViewById<ImageView>(R.id.intro_image)
        private val imageDecor = view.findViewById<ImageView>(R.id.intro_decor_splash)

        fun bind(introSlide: IntroSlide) {
            textTitle.text = introSlide.title
            textDescription.text = introSlide.description
            image.setImageResource(introSlide.image)
            imageDecor.setImageResource(introSlide.imageDecor)
        }
    }


    data class IntroSlide (
        val title: String,
        val description: String,
        val image: Int,
        val imageDecor: Int

    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IntroSliderViewHolder {
        return IntroSliderViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.slide_item_container,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int {
        return introSlides.size
    }

    override fun onBindViewHolder(holder: IntroSliderViewHolder, position: Int) {
        holder.bind(introSlides[position])
    }
}