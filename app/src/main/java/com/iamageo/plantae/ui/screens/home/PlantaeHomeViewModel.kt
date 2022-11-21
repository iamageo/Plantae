package com.iamageo.plantae.ui.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.plantae.PlantaeGeneralEvents
import com.iamageo.plantae.PlantaeStates
import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.usecases.PlantUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlantaeHomeViewModel @Inject constructor(
    private val plantUseCases: PlantUseCases
) : ViewModel() {

    private val _state = mutableStateOf(PlantaeStates())
    val state: State<PlantaeStates> = _state

    private var recentlyDeletedPlant: Plant? = null

    private var getPlantsJob: Job? = null

    init {
        getPlants()
    }

    fun onEvent(event: PlantaeGeneralEvents) {
        when (event) {
            is PlantaeGeneralEvents.DeletePlant -> {
                Log.i("TAG Plantae ->", "onEvent: delete plant " + event.plant)
                viewModelScope.launch {
                    plantUseCases.deletePlant(event.plant)
                    recentlyDeletedPlant = event.plant
                }
            }
            is PlantaeGeneralEvents.RestoreDeletedPlant -> {
                Log.i("TAG Plantae ->", "onEvent: restore plant")
                viewModelScope.launch {
                    plantUseCases.addPlant(recentlyDeletedPlant ?: return@launch)
                    recentlyDeletedPlant = null
                }
            }
        }
    }

    private fun getPlants() {
        getPlantsJob?.cancel()
        getPlantsJob = plantUseCases.getAllPlants()
            .onEach { plants -> _state.value = state.value.copy(plants = plants) }
            .launchIn(viewModelScope)
    }

}