package com.khudyakov.carstore.ui.add

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.khudyakov.carstore.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarForm(
    name: String,
    onNameChange: (String) -> Unit,
    year: String,
    onYearChange: (String) -> Unit,
    volume: String,
    onVolumeChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> if (uri != null) imageUri = uri }
    )

    Column(modifier = modifier.padding(all = 16.dp)) {
        Button(
            onClick = {
                val imageType = ActivityResultContracts.PickVisualMedia.ImageOnly
                launcher.launch(PickVisualMediaRequest(mediaType = imageType))
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Pick")
        }
        Text(text = imageUri.toString(), modifier = Modifier.padding(top = 16.dp))
        AsyncImage(
            model = imageUri,
            contentDescription = null,
            modifier = Modifier.padding(top = 16.dp).height(80.dp)
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = {
                Text(text = stringResource(id = R.string.name))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
                capitalization = KeyboardCapitalization.Words
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
        OutlinedTextField(
            value = year,
            onValueChange = onYearChange,
            label = {
                Text(text = stringResource(id = R.string.year))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.NumberPassword,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
        OutlinedTextField(
            value = volume,
            onValueChange = onVolumeChange,
            label = {
                Text(text = stringResource(id = R.string.volume))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.padding(top = 16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CarFormPreview() {
    CarForm(
        name = "Toyota",
        onNameChange = {},
        year = "2013",
        onYearChange = {},
        volume = "1.6",
        onVolumeChange = {}
    )
}
