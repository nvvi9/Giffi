package com.nvvi9.giffi.network

import com.nvvi9.giffi.network.model.TrendingResponse
import com.nvvi9.giffi.network.service.GiphyApiService
import javax.inject.Inject

class GiphyNetworkDataSource @Inject constructor(
    private val giphyApiService: GiphyApiService
) : GiphyDataSource {

    override suspend fun getTrending(): Result<TrendingResponse> = runCatching {
        giphyApiService.getTrending()
    }
}