package com.iamageo.plantae.ui.screens.home

import java.util.concurrent.TimeUnit
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PlantaeViewModel @Inject constructor(

): ViewModel() {

    internal fun scheduleReminder(
        duration: Long,
        unit: TimeUnit,
        plantName: String
    ) {

    }

}