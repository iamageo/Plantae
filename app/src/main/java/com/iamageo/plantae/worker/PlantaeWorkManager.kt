package com.iamageo.plantae.worker

import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.iamageo.plantae.PlantMainActivity
import com.iamageo.plantae.R
import com.iamageo.plantae.di.PlantaeApp

class PlantaeWorkManager(
    context: Context,
    workerParams: WorkerParameters
) : Worker(context, workerParams) {

    // Arbitrary id number
    val notificationId = 17

    override fun doWork(): Result {
        val intent = Intent(applicationContext, PlantMainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent
            .getActivity(applicationContext, 0, intent, 0)

        val plantName = inputData.getString(nameKey)

        val builder = NotificationCompat.Builder(applicationContext, PlantaeApp.CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle("Está na hora da rega!")
            .setContentText("A plantinha $plantName está lhe esperando")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(applicationContext)) {
            notify(notificationId, builder.build())
        }

        return Result.success()
    }

    companion object {
        const val nameKey = "NAME"
    }
}