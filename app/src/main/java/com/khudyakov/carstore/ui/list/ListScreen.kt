package com.khudyakov.carstore.ui.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.twotone.DirectionsCar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.khudyakov.carstore.data.car.Car

@Composable
fun ListScreen(viewModel: ListViewModel, onAddClick: () -> Unit) {
    val cars = viewModel.cars.collectAsState(initial = emptyList())
    ListScreen(cars = cars.value, onAddClick = onAddClick)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(cars: List<Car>, onAddClick: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Icon(imageVector = Icons.TwoTone.DirectionsCar, contentDescription = null)
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Default.Settings, contentDescription = null)
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick, shape = CircleShape) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(count = 2),
            modifier = Modifier.padding(padding)
        ) {
            items(cars) { car ->
                CarItem(car = car)
            }
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
    ListScreen(cars = cars, onAddClick = {})
}
