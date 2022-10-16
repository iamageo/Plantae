package com.iamageo.plantae.data.datasource

import androidx.room.*
import com.iamageo.plantae.domain.model.Plant
import kotlinx.coroutines.flow.Flow

@Dao
interface PlantaeDAO {

    @Query("SELECT * FROM plant")
    fun getAllPlants(): Flow<List<Plant>>

    @Query("SELECT * FROM plant WHERE id = :id")
    suspend fun getPlantsById(id: Int): Plant?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlant(plant: Plant)

    @Delete
    suspend fun deletePlant(plant: Plant)

}