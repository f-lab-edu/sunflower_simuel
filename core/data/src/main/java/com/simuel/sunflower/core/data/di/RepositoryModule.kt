package com.simuel.sunflower.core.data.di

import com.simuel.sunflower.core.data.repository.GardenRepositoryImpl
import com.simuel.sunflower.core.data.repository.PlantRepositoryImpl
import com.simuel.sunflower.core.domain.repository.GardenRepository
import com.simuel.sunflower.core.domain.repository.PlantRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal abstract class RepositoryModule {
    @Binds
    abstract fun bindPlantRepository(plantRepository: PlantRepositoryImpl): PlantRepository

    @Binds
    abstract fun bindGardenRepository(gardenRepository: GardenRepositoryImpl): GardenRepository
}
