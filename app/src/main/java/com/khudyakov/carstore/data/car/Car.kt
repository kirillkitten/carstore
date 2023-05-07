package com.khudyakov.carstore.data.car

data class Car(
    val name: String,
    val imagePath: String,
    val year: Int,
    val volume: Double,
    val date: Long
) {
    val id: Long = date
}
