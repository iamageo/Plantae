package com.iamageo.plantae.ui.screens.add

import android.app.Application
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.iamageo.plantae.PlantaeStates
import com.iamageo.plantae.PlantaeUiEvents
import com.iamageo.plantae.domain.model.InvalidPlantException
import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.usecases.PlantUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantaeAddViewModel @Inject constructor(
    application: Application,
    private val plantaeUseCases: PlantUseCases
) : ViewModel() {

    private val _state = mutableStateOf(PlantaeStates())
    val state: State<PlantaeStates> = _state

    private var currentPlantId: Int? = null

    private val _plantName = mutableStateOf(
        PlantEditTextState()
    )
    val plantName: State<PlantEditTextState> = _plantName

    private val _plantSpecie = mutableStateOf(
        PlantEditTextState()
    )
    val plantSpecie: State<PlantEditTextState> = _plantSpecie

    private val _eventFlow = MutableSharedFlow<PlantaeUiEvents>()
    val eventFlow = _eventFlow.asSharedFlow()

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
            is PlantaeAddEvents.SaveNewPlant -> {
                viewModelScope.launch {
                    try {
                        plantaeUseCases.addPlant(
                            Plant(
                                id = currentPlantId,
                                name =  plantName.value.text,
                                schedule =  "teste",
                                type =  plantSpecie.value.text,
                                description =  "description teste",
                            )
                        )
                        _eventFlow.emit(PlantaeUiEvents.SaveNewPlant)
                    } catch (e: InvalidPlantException) {
                        Log.i("Plantae LOG -> ", "onEvent: " + e.message)
                    }
                }
            }
        }
    }

}