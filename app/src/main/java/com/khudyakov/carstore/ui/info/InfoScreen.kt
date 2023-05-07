package com.khudyakov.carstore.ui.info

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.khudyakov.carstore.data.car.Car
import com.khudyakov.carstore.ui.theme.CarStoreTheme

@Composable
fun InfoScreen(viewModel: InfoViewModel, onBack: () -> Unit) {
    val car = viewModel.car.collectAsState(null).value ?: return
    InfoScreen(car = car, onBack)
}

@Composable
fun InfoScreen(car: Car, onBack: () -> Unit) {

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
