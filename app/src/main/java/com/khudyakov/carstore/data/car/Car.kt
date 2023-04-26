package com.khudyakov.carstore.data.car

import java.util.Date

data class Car(
    val name: String,
    val imagePath: String,
    val year: Int,
    val volume: Double,
    val date: Date
)
