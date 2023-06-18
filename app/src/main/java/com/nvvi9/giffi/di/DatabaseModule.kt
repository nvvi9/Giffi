package com.nvvi9.giffi.di

import android.content.Context
import androidx.room.Room
import com.nvvi9.giffi.database.GiffiDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideGiffiDatabase(@ApplicationContext context: Context): GiffiDatabase =
        Room.databaseBuilder(context, GiffiDatabase::class.java, "giffi-database").build()
}