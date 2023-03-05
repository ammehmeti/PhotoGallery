package com.mobilelife.photogallery.di

import com.mobilelife.photogallery.data.RepositoryImpl
import com.mobilelife.photogallery.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    abstract fun picSumRepository(repository: RepositoryImpl): Repository
}
