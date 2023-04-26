package com.khudyakov.carstore.data.car.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("cars")
data class CarLocalModel(
    val name: String,
    @ColumnInfo("image_path") val imagePath: String,
    val year: Int,
    val volume: Double,
    @PrimaryKey val date: Long
)
