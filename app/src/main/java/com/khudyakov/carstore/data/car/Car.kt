package com.khudyakov.carstore.data.car

import java.util.Date

data class Car(
    val id: Long,
    val name: String,
    val imagePath: String,
    val year: Int,
    val date: Date
)
