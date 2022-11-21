package com.iamageo.plantae

sealed class PlantaeUiEvents() {
    data class ShowSnackBar(val message: String) : PlantaeUiEvents()
    object SaveNewPlant : PlantaeUiEvents()
}