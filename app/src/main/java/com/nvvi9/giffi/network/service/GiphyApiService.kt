package com.nvvi9.giffi.network.service

import com.nvvi9.giffi.network.model.TrendingResponse

interface GiphyApiService {
    suspend fun getTrending(): TrendingResponse
}