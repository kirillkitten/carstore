package com.khudyakov.carstore.ui.info

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.khudyakov.carstore.R
import com.khudyakov.carstore.data.car.Car
import com.khudyakov.carstore.ui.theme.CarStoreTheme
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun InfoScreen(viewModel: InfoViewModel, onBack: () -> Unit) {
    val car = viewModel.car.collectAsState(null).value ?: return
    InfoScreen(car = car, onBack)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InfoScreen(car: Car, onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Icon(imageVector = Icons.Default.DirectionsCar, contentDescription = null)
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        InfoScreenContent(car = car, modifier= Modifier.padding(padding))
    }
}

@Composable
fun InfoScreenContent(car: Car, modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        AsyncImage(
            model = car.imagePath,
            contentDescription = null,
            placeholder = ColorPainter(color = Color.Gray),
            contentScale = ContentScale.FillWidth,
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(4f / 3f)
        )
        Text(text = car.name, modifier = Modifier.padding(horizontal = 16.dp, vertical = 24.dp))
        Row(modifier = Modifier.padding(horizontal = 16.dp)) {
            Column(modifier = Modifier.wrapContentWidth()) {
                Text(
                    text = "${stringResource(id = R.string.year).lowercase()}:",
                )
                Text(
                    text = "${stringResource(id = R.string.volume).lowercase()}:",
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = "${stringResource(id = R.string.date).lowercase()}:",
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(text = car.year.toString())
                Text(
                    text = "%.1f".format(car.volume),
                    modifier = Modifier.padding(top = 16.dp)
                )
                Text(
                    text = SimpleDateFormat
                        .getDateTimeInstance(1, 3)
                        .format(Date(car.date)),
                    modifier = Modifier.padding(top = 16.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun InfoScreenPreview() {
    CarStoreTheme {
        InfoScreen(
            car = Car("Toyota", "", 2008, 1.6, System.currentTimeMillis()),
            onBack = {}
        )
    }
}
