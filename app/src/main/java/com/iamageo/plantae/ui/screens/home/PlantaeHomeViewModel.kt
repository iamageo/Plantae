package com.iamageo.plantae.ui.screens.home

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iamageo.plantae.PlantaeStates
import com.iamageo.plantae.domain.model.Plant
import com.iamageo.plantae.domain.usecases.PlantUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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

    private fun getPlants() {
        getPlantsJob?.cancel()
        getPlantsJob = plantUseCases.getAllPlants()
            .onEach { plants -> _state.value = state.value.copy(plants = plants) }
            .launchIn(viewModelScope)
    }

}