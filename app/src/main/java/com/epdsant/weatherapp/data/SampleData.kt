package com.epdsant.weatherapp.data

import com.epdsant.weatherapp.data.model.FutureModel
import com.epdsant.weatherapp.data.model.HourlyModel

object SampleData {
    //Sample daily data item
    val dailyItems = listOf(
        FutureModel("Sat", "storm", "Storm", 24, 22),
        FutureModel("Sun", "cloudy", "Cloudy", 25, 22),
        FutureModel("Mon", "windy", "Windy", 29, 22),
        FutureModel("Tue", "cloudy_sunny", "Cloudy Sunny", 23, 22),
        FutureModel("Wed", "sunny", "Sunny", 28, 22),
        FutureModel("Thu", "rain", "Rainy", 23, 22),
        FutureModel("Fri", "cloudy_sunny", "Cloudy Sunny", 28, 22),
    )

    //Sample hourly forecast data item
    val hourlyItems = listOf(
        HourlyModel("9 am", 25, "cloudy"),
        HourlyModel("10 am", 28, "sunny"),
        HourlyModel("11 am", 26, "wind"),
        HourlyModel("12 pm", 21, "rainy"),
        HourlyModel("1 pm", 20, "storm")
    )
}