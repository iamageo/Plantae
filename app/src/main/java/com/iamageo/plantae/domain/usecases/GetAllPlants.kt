package com.iamageo.plantae.domain.usecases

import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.repository.PlantRepository
import kotlinx.coroutines.flow.Flow

class GetAllPlants(
    private val plantRepository: PlantRepository
) {

    suspend fun invoke() : Flow<List<Plant>> {
        return plantRepository.getAllPlants()
    }

}