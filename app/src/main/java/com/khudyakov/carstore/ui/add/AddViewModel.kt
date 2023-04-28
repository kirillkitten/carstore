package com.khudyakov.carstore.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.khudyakov.carstore.data.car.Car
import com.khudyakov.carstore.data.car.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val carRepository: CarRepository) : ViewModel() {

    fun addCar(car: Car) {
        viewModelScope.launch {
            try {
                carRepository.addCar(car)
            } catch (e: Exception) {
                Timber.e(e, "Failed to save car")
            }
        }
    }
}
