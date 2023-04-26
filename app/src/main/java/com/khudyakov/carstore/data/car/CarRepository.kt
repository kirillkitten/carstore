package com.khudyakov.carstore.data.car

import com.khudyakov.carstore.data.car.database.CarDao
import com.khudyakov.carstore.data.car.database.CarLocalModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.Date
import javax.inject.Inject

class CarRepository @Inject constructor(private val database: CarDao) {

    private val CarLocalModel.asDomainModel
        get() = Car(name, imagePath, year, volume, Date(date))

    private val Car.asLocalModel
        get() = CarLocalModel(name, imagePath, year, volume, date.time)

    fun getCars(): Flow<List<Car>> = database.getCars().map { list ->
        list.map { carLocal -> carLocal.asDomainModel }
    }

    suspend fun addCar(car: Car) = database.insertCar(car.asLocalModel)

}
