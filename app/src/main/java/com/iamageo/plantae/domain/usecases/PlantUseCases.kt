package com.iamageo.plantae.domain.usecases

data class PlantUseCases(
    val addPlant: AddPlant,
    val getAllPlants: GetAllPlants,
    val deletePlant: DeletePlant,
    val getPlantById: GetPlantById
)