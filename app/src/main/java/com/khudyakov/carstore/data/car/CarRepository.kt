package com.khudyakov.carstore.data.car

import kotlinx.coroutines.flow.Flow

class CarRepository {

    suspend fun getCars(): Flow<List<Car>> {
        TODO()
    }

    suspend fun addCar(car: Car) {
        TODO()
    }
}
