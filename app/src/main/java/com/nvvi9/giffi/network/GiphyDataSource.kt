package com.nvvi9.giffi.network

import com.nvvi9.giffi.network.model.TrendingResponse

interface GiphyDataSource {
    suspend fun getTrending(): Result<TrendingResponse>
}