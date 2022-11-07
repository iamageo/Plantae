package com.iamageo.plantae.ui.screens.home

import androidx.lifecycle.ViewModel
import com.iamageo.plantae.domain.usecases.PlantUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class PlantaeHomeViewModel @Inject constructor(
    private val plantaeUseCases: PlantUseCases
) : ViewModel() {

    internal fun scheduleReminder(
        duration: Long,
        unit: TimeUnit,
        plantName: String
    ) {

    }

}