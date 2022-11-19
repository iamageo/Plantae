package com.iamageo.plantae.ui.screens.add

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class PlantaeAddViewModel : ViewModel() {

    private val _plantName = mutableStateOf(
        PlantEditTextState()
    )
    val plantName: State<PlantEditTextState> = _plantName

    private val _plantSpecie = mutableStateOf(
        PlantEditTextState()
    )
    val plantSpecie: State<PlantEditTextState> = _plantSpecie

    fun onEvent(event: PlantaeAddEvents) {
        when (event) {
            is PlantaeAddEvents.EnteredPlantName -> {
                _plantName.value = plantName.value.copy(
                    text = event.plantName
                )
            }
            is PlantaeAddEvents.EnteredPlantSpecie -> {
                _plantSpecie.value = plantSpecie.value.copy(
                    text = event.plantSpecie
                )
            }
        }
    }

}