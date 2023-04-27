package com.khudyakov.carstore.ui.list

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.khudyakov.carstore.data.car.Car

@Composable
fun ListScreen(viewModel: ListViewModel) {
    val cars = viewModel.cars.collectAsState(initial = emptyList())
    ListScreen(cars = cars.value, onCarAdded = viewModel::addCar)
}

@Composable
fun ListScreen(cars: List<Car>, onCarAdded: (Car) -> Unit) {
    LazyVerticalGrid(columns = GridCells.Fixed(count = 2)) {
        items(cars) { car ->
            CarItem(car = car)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListScreenPreview() {
    val time = System.currentTimeMillis()
    val cars = listOf(
        Car("Toyota", "", 2008, 1.6, time),
        Car("Ford", "", 2005, 2.0, time - 100000000L),
        Car("Lada", "", 2011, 1.4, time - 200000000L),
        Car("Volkswagen", "", 2020, 1.6, time - 300000000L)
    )
    ListScreen(cars = cars, onCarAdded = {})
}
