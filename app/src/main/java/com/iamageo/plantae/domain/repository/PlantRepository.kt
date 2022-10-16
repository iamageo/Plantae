package com.iamageo.plantae.domain.repository

import com.iamageo.plantae.domain.model.Plant
import kotlinx.coroutines.flow.Flow

interface PlantRepository {

    fun getAllPlants(): Flow<List<Plant>>

    suspend fun getPlantsById(id: Int): Plant?

    suspend fun insertPlant(plant: Plant)

    suspend fun deletePlant(plant: Plant)

}