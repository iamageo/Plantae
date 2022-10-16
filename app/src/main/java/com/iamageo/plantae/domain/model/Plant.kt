package com.iamageo.plantae.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Plant(
    val name: String,
    val schedule: String,
    val type: String,
    val description: String,
    @PrimaryKey val id: Int? = null
)

class InvalidPlantException(message: String) : Exception(message)
