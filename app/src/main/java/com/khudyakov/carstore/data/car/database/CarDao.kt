package com.khudyakov.carstore.data.car.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CarDao {
    @Query("SELECT * FROM cars")
    fun getCars(): Flow<List<CarLocalModel>>

    @Insert
    suspend fun insertCar(car: CarLocalModel)
}
