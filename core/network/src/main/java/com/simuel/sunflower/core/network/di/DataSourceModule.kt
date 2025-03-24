package com.simuel.sunflower.core.network.di

import com.simuel.sunflower.core.data.source.RemoteGalleryDataSource
import com.simuel.sunflower.core.network.datasource.RemoteGalleryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal abstract class DataSourceModule {

    @Binds
    @Singleton
    abstract fun bindRemoteGalleryDataSource(dataSource: RemoteGalleryDataSourceImpl): RemoteGalleryDataSource
}
