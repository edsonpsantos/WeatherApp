package com.epdsant.weatherapp.data.model

data class FutureModel(
    val day: String,
    val picPath: String,
    val status: String,
    val highTemp: Int,
    val lowTemp: Int
)
