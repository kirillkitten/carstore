package com.khudyakov.carstore.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.khudyakov.carstore.data.car.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val carRepository: CarRepository) : ViewModel() {

    var name by mutableStateOf("")
        private set

    var year by mutableStateOf("")
        private set

    var volume by mutableStateOf("")
        private set

    fun addCar() {
//        viewModelScope.launch {
//            try {
//                carRepository.addCar(car)
//            } catch (e: Exception) {
//                Timber.e(e, "Failed to save car")
//            }
//        }
    }

    fun updateName(input: String) {
        name = input
    }

    fun updateYear(input: String) {
        year = input
    }

    fun updateNVolume(input: String) {
        volume = input
    }
}
