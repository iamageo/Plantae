package com.iamageo.plantae.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.iamageo.plantae.data.datasource.PlantDatabase
import com.iamageo.plantae.data.repository.PlantRepositoryImpl
import com.iamageo.plantae.domain.repository.PlantRepository
import com.iamageo.plantae.domain.usecases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePlantaeDatabase(app: Application): PlantDatabase {
        return Room.databaseBuilder(
            app,
            PlantDatabase::class.java,
            PlantDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun providePlantaeRepository(db: PlantDatabase): PlantRepository {
        return PlantRepositoryImpl(db.plantaeDAO)
    }

    @Provides
    @Singleton
    fun provideNottyeUseCases(repository: PlantRepository): PlantUseCases {
        return PlantUseCases(
            addPlant = AddPlant(repository),
            deletePlant = DeletePlant(repository),
            getAllPlants = GetAllPlants(repository),
            getPlantById = GetPlantById(repository)
        )
    }

}