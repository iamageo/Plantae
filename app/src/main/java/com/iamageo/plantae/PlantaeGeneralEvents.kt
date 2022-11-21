package com.iamageo.plantae

import com.iamageo.plantae.domain.model.Plant

sealed class PlantaeGeneralEvents {
    object RestoreDeletedPlant : PlantaeGeneralEvents()
    data class DeletePlant(val plant: Plant) : PlantaeGeneralEvents()
}