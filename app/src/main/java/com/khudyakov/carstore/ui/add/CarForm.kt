package com.khudyakov.carstore.ui.add

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddAPhoto
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.khudyakov.carstore.R
import com.khudyakov.carstore.ui.theme.CarStoreTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarForm(
    name: String,
    onNameChange: (String) -> Unit,
    year: String,
    onYearChange: (String) -> Unit,
    volume: String,
    onVolumeChange: (String) -> Unit,
    image: Uri?,
    onImageChange: (Uri?) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        ImagePicker(imageUri = image, onImageUpdate = onImageChange)
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

@Composable
fun ImagePicker(imageUri: Uri?, onImageUpdate: (Uri?) -> Unit) {
    val size = 200.dp
    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = onImageUpdate
    )
    val interaction = remember { MutableInteractionSource() }
    Box(
        modifier = Modifier
            .height(size)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.outline,
                shape = RoundedCornerShape(4.dp)
            )
            .clickable(
                interactionSource = interaction,
                indication = null
            ) {
                val imageType = ActivityResultContracts.PickVisualMedia.ImageOnly
                launcher.launch(PickVisualMediaRequest(mediaType = imageType))
            },
        contentAlignment = Alignment.Center
    ) {
        if (imageUri == null) {
            Icon(
                imageVector = Icons.Outlined.AddAPhoto,
                contentDescription = null,
                modifier = Modifier.width(size)
            )
        } else {
            AsyncImage(
                model = imageUri,
                contentDescription = null,
                modifier = Modifier,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CarFormPreviewLight() {
    CarStoreTheme {
        CarForm(
            name = "Toyota",
            onNameChange = {},
            year = "2013",
            onYearChange = {},
            volume = "1.6",
            onVolumeChange = {},
            image = null,
            onImageChange = {}
        )
    }
}
