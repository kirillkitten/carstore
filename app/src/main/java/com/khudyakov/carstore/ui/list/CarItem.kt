package com.khudyakov.carstore.ui.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.khudyakov.carstore.data.car.Car
import com.khudyakov.carstore.ui.theme.CarStoreTheme

@Composable
fun CarItem(car: Car, onClick: (Long) -> Unit) {
    Column(
        modifier = Modifier
            .clickable {
                onClick(car.id)
            }
            .padding(all = 16.dp)
    ) {
        AsyncImage(
            model = car.imagePath,
            contentDescription = null,
            placeholder = ColorPainter(color = Color.Gray),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
                .clip(RoundedCornerShape(16.dp))
        )
        Text(text = car.name, modifier = Modifier.padding(top = 8.dp))
        Text(text = car.year.toString(), modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview(showBackground = true, widthDp = 160)
@Composable
fun CarItemPreview() {
    CarStoreTheme {
        CarItem(
            car = Car("Toyota", "", 2008, 1.6, System.currentTimeMillis()),
            onClick = {}
        )
    }
}
