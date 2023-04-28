package com.khudyakov.carstore.ui.add

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.twotone.DirectionsCar
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun AddScreen(viewModel: AddViewModel, onCancel: () -> Unit) {
    AddScreen(
        onAdd = viewModel::addCar,
        onCancel = onCancel,
        name = viewModel.name,
        onNameChange = viewModel::updateName,
        year = viewModel.year,
        onYearChange = viewModel::updateYear,
        volume = viewModel.volume,
        onVolumeChange = viewModel::updateNVolume
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddScreen(
    onAdd: () -> Unit,
    onCancel: () -> Unit,
    name: String,
    onNameChange: (String) -> Unit,
    year: String,
    onYearChange: (String) -> Unit,
    volume: String,
    onVolumeChange: (String) -> Unit,
) {
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
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAdd, shape = CircleShape) {
                Icon(imageVector = Icons.Default.Done, contentDescription = null)
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { padding ->
        CarForm(
            name = name,
            onNameChange = onNameChange,
            year = year,
            onYearChange = onYearChange,
            volume = volume,
            onVolumeChange = onVolumeChange,
            modifier = Modifier.padding(padding)
        )
    }
}

@Preview
@Composable
fun AddScreenPreview() {
    AddScreen(
        onAdd = {},
        onCancel = {},
        name = "Toyota",
        onNameChange = {},
        year = "2013",
        onYearChange = {},
        volume = "1.6",
        onVolumeChange = {}
    )
}
