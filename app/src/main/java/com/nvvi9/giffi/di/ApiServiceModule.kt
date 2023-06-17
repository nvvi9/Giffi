package com.nvvi9.giffi.di

import com.nvvi9.giffi.network.service.GiphyApiService
import com.nvvi9.giffi.network.service.GiphyApiServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ApiServiceModule {

    @Binds
    fun bind(giphyApiServiceImpl: GiphyApiServiceImpl): GiphyApiService
}