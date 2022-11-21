package com.iamageo.plantae.domain.usecases

import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.repository.PlantRepository

class DeletePlant(
    private val plantRepository: PlantRepository
) {

    suspend operator fun invoke(plant: Plant) {
        plantRepository.deletePlant(plant)
    }

}