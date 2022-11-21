package com.iamageo.plantae.domain.usecases

import com.iamageo.plantae.domain.model.InvalidPlantException
import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.repository.PlantRepository

class AddPlant(
    private val plantRepository: PlantRepository
) {
    @Throws(InvalidPlantException::class)
    suspend operator fun invoke(plant: Plant) {
        if (plant.name.isEmpty()) {
            throw InvalidPlantException("The name of plant cant be empty")
        }
        if (plant.description.isEmpty()) {
            throw InvalidPlantException("The name of plant cant be empty")
        }
        plantRepository.insertPlant(plant)
    }

}