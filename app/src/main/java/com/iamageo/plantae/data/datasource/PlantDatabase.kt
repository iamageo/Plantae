package com.iamageo.plantae.data.datasource

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iamageo.plantae.domain.model.Plant

@Database(
    entities = [Plant::class],
    version = 1
)
abstract class PlantDatabase : RoomDatabase() {

    abstract val plantaeDAO: PlantaeDAO

    companion object {
        const val DATABASE_NAME = "plantaedb"
    }

}