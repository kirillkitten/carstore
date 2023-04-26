package com.khudyakov.carstore.data.car.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [CarLocalModel::class], version = 1, exportSchema = false)
abstract class CarDatabase : RoomDatabase() {
    abstract fun carDao(): CarDao
}
