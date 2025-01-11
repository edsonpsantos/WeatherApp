package com.epdsant.weatherapp.domain.usecase

import androidx.compose.runtime.Composable
import com.epdsant.weatherapp.R


@Composable
fun getDrawableResourceId(picPath: String): Int {
    return when(picPath) {
        "storm"-> R.drawable.storm
        "cloudy" -> R.drawable.cloudy
        "sunny" -> R.drawable.sunny
        "wind" -> R.drawable.wind
        "rainy" -> R.drawable.rainy
        else -> R.drawable.sunny
    }
}