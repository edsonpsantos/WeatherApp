package com.epdsant.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epdsant.weatherapp.data.model.FutureModel
import com.epdsant.weatherapp.domain.usecase.getDrawableResourceId


//Display each future day forecast data item
@Composable
fun FutureDailyItem(dailyItem: FutureModel) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ){
        Text(
            dailyItem.day,
            color = Color.White,
            fontSize = 14.sp
        )

        Image(
            painter = painterResource(id = getDrawableResourceId(dailyItem.picPath)),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 32.dp)
                .size(45.dp)
        )

        Text(
            dailyItem.status,
            modifier = Modifier
                .weight(1f)
                .padding(start = 16.dp),
            color = Color.White,
            fontSize = 14.sp
        )

        Text("${dailyItem.highTemp}°",
            modifier= Modifier
                .padding(end = 16.dp),
            color = Color.White,
            fontSize = 14.sp
        )

        Text("${dailyItem.lowTemp}°",
            color = Color.White,
            fontSize = 14.sp
        )
    }
}