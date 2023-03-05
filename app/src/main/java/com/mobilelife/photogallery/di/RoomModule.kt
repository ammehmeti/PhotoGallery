package com.mobilelife.photogallery.di

import android.content.Context
import androidx.room.Room
import com.mobilelife.photogallery.data.local.PicSumDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DB_NAME = "picsum_db"

@InstallIn(SingletonComponent::class)
@Module
object RoomModule {

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context): PicSumDatabase {
        return Room.databaseBuilder(context, PicSumDatabase::class.java, DB_NAME)
            .build()
    }
}