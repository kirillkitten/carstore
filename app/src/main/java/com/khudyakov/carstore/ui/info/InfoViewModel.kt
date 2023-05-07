package com.khudyakov.carstore.ui.info

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.khudyakov.carstore.data.car.CarRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class InfoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    repository: CarRepository
) : ViewModel() {

    val car = savedStateHandle.getStateFlow<Long?>("carId", null).map { id ->
        if (id != null) repository.getCar(id) else null
    }
}
