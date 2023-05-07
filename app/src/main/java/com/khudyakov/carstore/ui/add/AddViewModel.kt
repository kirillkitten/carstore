package com.khudyakov.carstore.ui.add

import android.app.Application
import android.net.Uri
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.khudyakov.carstore.data.car.Car
import com.khudyakov.carstore.data.car.CarRepository
import com.khudyakov.carstore.data.storage.StorageManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    application: Application,
    private val carRepository: CarRepository,
    private val storageManager: StorageManager
) : AndroidViewModel(application) {

    var nameText by mutableStateOf("")
        private set

    var yearText by mutableStateOf("")
        private set

    var volumeText by mutableStateOf("")
        private set

    var imageUri by mutableStateOf<Uri?>(null)

    private var saving by mutableStateOf(false)

    val addButtonEnabled by derivedStateOf {
        val name = nameText.takeIf(String::isNotEmpty)
        val year = yearText.toIntOrNull()
        val volume = volumeText.toDoubleOrNull()?.takeIf { it > 0.0 }
        !saving && name != null && year != null && volume != null
    }

    var navigateUp by mutableStateOf(false)

    fun addCar() {
        saving = true

        val name = nameText.takeIf(String::isNotEmpty) ?: return
        val year = yearText.toIntOrNull() ?: return
        val volume = volumeText.toDoubleOrNull()?.takeIf { it > 0.0 } ?: return
        val image = imageUri ?: return
        val time = System.currentTimeMillis()

        viewModelScope.launch {
            val imagePath = storageManager.saveToInternalStorage(image).path
            carRepository.addCar(Car(name, imagePath, year, volume, time))
            navigateUp = true
        }
    }

    fun updateName(input: String) {
        nameText = input
    }

    fun updateYear(input: String) {
        yearText = input
    }

    fun updateNVolume(input: String) {
        volumeText = input
    }

    fun updateImage(uri: Uri?) {
        imageUri = uri
    }
}
