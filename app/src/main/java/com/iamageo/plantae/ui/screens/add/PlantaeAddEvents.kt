package com.iamageo.plantae.ui.screens.add

import androidx.compose.ui.focus.FocusState

sealed class PlantaeAddEvents {
    data class EnteredPlantName(val plantName: String) : PlantaeAddEvents()
    data class EnteredPlantSpecie(val plantSpecie: String) : PlantaeAddEvents()
    data class EnteredPlantSchedule(val plantSchedule: Int) : PlantaeAddEvents()
    object SaveNewPlant:  PlantaeAddEvents()
}
