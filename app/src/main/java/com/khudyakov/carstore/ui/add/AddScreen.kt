package com.khudyakov.carstore.ui.add

import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DirectionsCar
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.khudyakov.carstore.R

@Composable
fun AddScreen(viewModel: AddViewModel, onBack: () -> Unit) {
    if (viewModel.navigateUp) onBack()

    AddScreen(
        onAdd = viewModel::addCar,
        onCancel = onBack,
        name = viewModel.nameText,
        onNameChange = viewModel::updateName,
        year = viewModel.yearText,
        onYearChange = viewModel::updateYear,
        volume = viewModel.volumeText,
        onVolumeChange = viewModel::updateNVolume,
        image = viewModel.imageUri,
        onImageChange = viewModel::updateImage,
        addButtonEnabled = viewModel.addButtonEnabled
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
    image: Uri?,
    onImageChange: (Uri?) -> Unit,
    addButtonEnabled: Boolean
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Icon(imageVector = Icons.Default.DirectionsCar, contentDescription = null)
                },
                navigationIcon = {
                    IconButton(onClick = onCancel) {
                        Icon(imageVector = Icons.Default.Close, contentDescription = null)
                    }
                }
            )
        }
    ) { padding ->
        Column(modifier = Modifier
            .padding(padding)
            .padding(all = 16.dp)) {
            CarForm(
                name = name,
                onNameChange = onNameChange,
                year = year,
                onYearChange = onYearChange,
                volume = volume,
                onVolumeChange = onVolumeChange,
                image = image,
                onImageChange = onImageChange
            )
            Button(
                onClick = onAdd,
                enabled = addButtonEnabled,
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.save))
            }
        }
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
        onVolumeChange = {},
        image = null,
        onImageChange = {},
        addButtonEnabled = true
    )
}
