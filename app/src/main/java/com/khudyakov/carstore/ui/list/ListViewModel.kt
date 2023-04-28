package com.khudyakov.carstore.ui.list

import androidx.lifecycle.ViewModel
import com.khudyakov.carstore.data.car.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(carRepository: CarRepository) : ViewModel() {
    val cars = carRepository.getCars()
}
