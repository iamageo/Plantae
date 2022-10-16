package com.iamageo.plantae.data.repository

import com.iamageo.plantae.data.datasource.PlantaeDAO
import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow

class PlantRepositoryImpl(
    private val plantaeDAO: PlantaeDAO
): PlantRepository {
    override fun getAllPlants(): Flow<List<Plant>> {
        return plantaeDAO.getAllPlants()
    }

    override suspend fun getPlantsById(id: Int): Plant? {
        return plantaeDAO.getPlantsById(id)
    }

    override suspend fun insertPlant(plant: Plant) {
        return plantaeDAO.insertPlant(plant)
    }
    override suspend fun deletePlant(plant: Plant) {
        return plantaeDAO.deletePlant(plant)
    }
}