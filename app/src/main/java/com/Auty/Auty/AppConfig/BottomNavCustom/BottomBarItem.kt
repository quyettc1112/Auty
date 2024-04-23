package com.Auty.Auty.AppConfig.BottomNavCustom

import android.graphics.RectF
import android.graphics.drawable.Drawable

data class BottomBarItem(var title: String, val icon: Drawable,
                         var rect: RectF = RectF(), var badgeSize: Float = 0f)