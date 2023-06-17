package com.nvvi9.giffi.di

import com.nvvi9.giffi.network.GiphyDataSource
import com.nvvi9.giffi.network.GiphyNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataSourceModule {

    @Binds
    fun binds(giphyNetworkDataSource: GiphyNetworkDataSource): GiphyDataSource
}