package com.khudyakov.carstore.ui.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import com.khudyakov.carstore.data.car.Car

@Composable
fun ListScreen(viewModel: ListViewModel) {
    val cars = viewModel.cars.collectAsState(initial = emptyList())
    ListScreen(cars = cars.value, onCarAdded = viewModel::addCar)
}

@Composable
fun ListScreen(cars: List<Car>, onCarAdded: (Car) -> Unit) {}
