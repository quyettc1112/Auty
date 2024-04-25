package com.Auty.Auty.Common

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.Auty.Auty.R
import org.w3c.dom.Text

class RecommendSliderAdapter(private val courseRecomment: List<CourseRecomment>):
    RecyclerView.Adapter<RecommendSliderAdapter.RecommendSliderHolder>()
{
    inner class RecommendSliderHolder(view: View): RecyclerView.ViewHolder(view) {
        private val title = view.findViewById<TextView>(R.id.tv_course_title)
        private val image = view.findViewById<ImageView>(R.id.iv_course_recommend)
        private val rating = view.findViewById<RatingBar>(R.id.ratingbar)
        private val reviewNumder = view.findViewById<TextView>(R.id.tv_numRating)
        fun bind(courseRecomment: CourseRecomment) {
            title.text = courseRecomment.title
            image.setImageResource(courseRecomment.image)
            rating.rating = courseRecomment.rating.toFloat()
            reviewNumder.text = "(${courseRecomment.reviewNumder.toString()})"
        }

    }

    data class CourseRecomment (
        val title: String,
        val image: Int,
        val rating: Double,
        val reviewNumder: Int
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendSliderHolder {
        return RecommendSliderHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.slide_item_course_recomment, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return courseRecomment.size
    }

    override fun onBindViewHolder(holder: RecommendSliderHolder, position: Int) {
        holder.bind(courseRecomment[position])

    }


}