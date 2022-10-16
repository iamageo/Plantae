package com.iamageo.plantae.domain.usecases

import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.repository.PlantRepository

class GetPlantById(
    private val plantRepository: PlantRepository
) {

    suspend fun invoke(id: Int): Plant? {
        return plantRepository.getPlantsById(id)
    }

}