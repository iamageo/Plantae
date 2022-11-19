package com.iamageo.plantae.ui.screens.home

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.work.Data
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.iamageo.plantae.domain.usecases.PlantUseCases
import com.iamageo.plantae.worker.PlantaeWorkManager
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class PlantaeHomeViewModel @Inject constructor(
    application: Application,
    private val plantaeUseCases: PlantUseCases
) : ViewModel() {

    //TODO: move this code from PlantaeAddViewModel
    private val workManager = WorkManager.getInstance(application)

    internal fun scheduleReminder(
        duration: Long,
        unit: TimeUnit,
        plantName: String
    ) {
        val data = Data.Builder().putString(PlantaeWorkManager.nameKey, plantName).build()

        val reminderWorkerRequest = OneTimeWorkRequestBuilder<PlantaeWorkManager>()
            .setInputData(data)
            .setInitialDelay(duration, unit)
            .build()

        workManager.enqueue(reminderWorkerRequest)
    }

}