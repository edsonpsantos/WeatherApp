import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.epdsant.weatherapp.R
import com.epdsant.weatherapp.data.SampleData.dailyItems
import com.epdsant.weatherapp.data.SampleData.hourlyItems
import com.epdsant.weatherapp.ui.components.FutureDailyItem
import com.epdsant.weatherapp.ui.components.FutureViewModelHolder
import com.epdsant.weatherapp.ui.components.WeatherDetailsItem

@Preview
@Composable
fun WeatherScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    Color(android.graphics.Color.parseColor("#59469D")),
                    Color(android.graphics.Color.parseColor("#643D67"))
                ),
            )
        )
    )
    {
        Column(modifier = Modifier.fillMaxSize()) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                item {
                    WeatherHeader()
                }

                //Display future hourly forecast with LazyRow
                item {
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ){
                        items(hourlyItems){ item ->
                            FutureViewModelHolder(item)
                        }
                    }
                }

                //Display Future label and next 7 days button
                item {
                    WeatherFutureLabel()
                }

                items(dailyItems) { dailyItem ->
                    FutureDailyItem(dailyItem)
                }

                item {
                    Spacer(modifier = Modifier.height(48.dp))
                }
            }
        }
    }
}

@Composable
private fun WeatherHeader() {
    Text("Mostly Cloudy",
        style =  TextStyle(fontSize = 20.sp),
        color = Color.White,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 48.dp),
        textAlign = TextAlign.Center
    )

    Image(painter = painterResource(id = R.drawable.cloudy_sunny)
        , contentDescription = "Cloudy sunny",
        modifier = Modifier
            .size(150.dp)
            .padding(top = 8.dp)
    )

    //Display date and time
    Text(
        "Mon Jan 11 | 10:30 AM",
        fontSize = 19.sp,
        color = Color.White,
        modifier = Modifier.padding(top = 8.dp),
        textAlign = TextAlign.Center
    )

    //Display temperature
    Text(
        "25°",
        fontSize = 63.sp,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.Center
    )

    Text(
        "H: 28° L: 22°",
        fontSize = 16.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        textAlign = TextAlign.Center
    )

    //Box container weather details like wind speed, humidity, etc
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 16.dp)
            .background(
                color = colorResource(id = R.color.purple),
                shape = RoundedCornerShape(25.dp)
            )
    ){
        Row(modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(horizontal = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ){

            WeatherDetailsItem(
                icon = R.drawable.rain,
                value = "20%",
                label = "Rain"
            )

            WeatherDetailsItem(
                icon = R.drawable.wind,
                value = "10km/h",
                label = "Wind Speed"
            )

            WeatherDetailsItem(
                icon = R.drawable.humidity,
                value = "85%",
                label = "Humidity"
            )
        }

    }
    //Display Today label
    Text(
        text = "Today",
        fontSize = 20.sp,
        color = Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
    )
}

@Composable
private fun WeatherFutureLabel(modifier: Modifier = Modifier) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 24.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Future",
            fontSize = 20.sp,
            color = Color.White,
            modifier = Modifier.weight(1f)
        )

        Text("Next7 days >>",
            fontSize = 14.sp,
            color = Color.White,
            fontWeight = FontWeight.Bold,
        )
    }
}

