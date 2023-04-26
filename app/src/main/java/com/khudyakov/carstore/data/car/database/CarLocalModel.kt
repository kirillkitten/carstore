package com.khudyakov.carstore.data.car.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cars")
data class CarLocalModel(
    val name: String,
    @ColumnInfo(name = "image_path") val imagePath: String,
    val year: Int,
    val volume: Double,
    @PrimaryKey val date: Long
)
