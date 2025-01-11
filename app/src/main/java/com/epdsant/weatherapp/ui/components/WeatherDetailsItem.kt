package com.epdsant.weatherapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.epdsant.weatherapp.R


@Composable
fun WeatherDetailsItem(icon: Int, value: String, label: String){
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(34.dp)
        )

        Text(
            text = value,
            style = TextStyle(fontWeight = FontWeight.Bold),
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )

        Text(
            text = label,
            color = colorResource(id = R.color.white),
            textAlign = TextAlign.Center
        )
    }
}

