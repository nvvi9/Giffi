package com.nvvi9.giffi.di

import com.nvvi9.giffi.database.GiffiDatabase
import com.nvvi9.giffi.database.dao.GifAuthorDao
import com.nvvi9.giffi.database.dao.GifDataDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    fun provideGifAuthorsDao(database: GiffiDatabase): GifAuthorDao =
        database.gifAuthorDao

    @Provides
    fun provideGifDataDao(database: GiffiDatabase): GifDataDao =
        database.gifDataDao
}