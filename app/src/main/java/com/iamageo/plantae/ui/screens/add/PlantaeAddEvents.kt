package com.iamageo.plantae.ui.screens.add

import androidx.compose.ui.focus.FocusState

sealed class PlantaeAddEvents {
    data class EnteredPlantName(val plantName: String) : PlantaeAddEvents()
}
