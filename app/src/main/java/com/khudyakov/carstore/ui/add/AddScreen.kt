package com.khudyakov.carstore.ui.add

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.twotone.DirectionsCar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.khudyakov.carstore.data.car.Car

@Composable
fun AddScreen(viewModel: AddViewModel, onCancel: () -> Unit) {
    AddScreen(onAdd = viewModel::addCar, onCancel = onCancel)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(onAdd: (Car) -> Unit, onCancel: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Icon(imageVector = Icons.TwoTone.DirectionsCar, contentDescription = null)
                },
                navigationIcon = {
                    IconButton(onClick = onCancel) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        CarForm(modifier = Modifier.padding(padding))
    }
}

@Preview
@Composable
fun AddScreenPreview() {
    AddScreen(onAdd = {}, onCancel = {})
}
