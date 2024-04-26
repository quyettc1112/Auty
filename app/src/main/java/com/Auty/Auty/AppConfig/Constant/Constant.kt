package com.Auty.Auty.AppConfig.Constant

import android.view.animation.AnimationUtils
import com.Auty.Auty.Common.CourseMainAdapter
import com.Auty.Auty.R

class Constant {
    companion object {
        const val DEFAULT_ERROR_MESSAGE: String = "An error occurred"

        // Nice Bottom Nav Bar
        const val ITEM_TAG = "item"
        const val ICON_ATTRIBUTE = "icon"
        const val TITLE_ATTRIBUTE = "title"
        const val WHITE_COLOR_HEX = "#FFFFFF"

        const val DEFAULT_INDICATOR_COLOR = "#426dfe"
        const val DEFAULT_TEXT_COLOR = "#444444"
        const val DEFAULT_TEXT_COLOR_ACTIVE = "#426dfe"

        const val DEFAULT_PRIMARY_COLOR = "#17A4FE"
        const val DEFAULT_PRIMARY_COLOR_ACTIVE = "#85C6EF"


        fun getListCourse(): List<CourseMainAdapter.Course> {
            return listOf(
                CourseMainAdapter.Course(
                    title = "Cách nhận biết trẻ bị tự kỷ",
                    image = R.drawable.ic_materaial_course,
                    rating = 4.5,
                    reviews = 4242,
                    originalPrice = 400000.0,
                    discountedPrice = 350000.0
                ),

                CourseMainAdapter.Course(
                    title = "Biểu hiện của trẻ bị tự kỷ theo các mức độ",
                    image = R.drawable.ic_materaial_course,
                    rating = 4.5,
                    reviews = 4242,
                    originalPrice = 400000.0,
                    discountedPrice = 350000.0
                ),

                CourseMainAdapter.Course(
                    title = "Cách nhận biết trẻ bị tự kỷ",
                    image = R.drawable.ic_material_recommend,
                    rating = 4.5,
                    reviews = 4242,
                    originalPrice = 400000.0,
                    discountedPrice = 350000.0
                ),

                CourseMainAdapter.Course(
                    title = "Độ tuổi dễ bị tổn thương sâu sắc về tình cảm",
                    image = R.drawable.ic_material_aytism,
                    rating = 4.5,
                    reviews = 4242,
                    originalPrice = 400000.0,
                    discountedPrice = 350000.0
                ),

                CourseMainAdapter.Course(
                    title = "Cách nhận biết trẻ bị tự kỷ",
                    image = R.drawable.ic_materaial_course,
                    rating = 4.5,
                    reviews = 4242,
                    originalPrice = 400000.0,
                    discountedPrice = 350000.0
                ),
                CourseMainAdapter.Course(
                    title = "Cách nhận biết trẻ bị tự kỷ",
                    image = R.drawable.ic_materaial_course,
                    rating = 4.5,
                    reviews = 4242,
                    originalPrice = 400000.0,
                    discountedPrice = 350000.0
                )
            )


        }

    }


}