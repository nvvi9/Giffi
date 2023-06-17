package com.nvvi9.giffi.network.service

import com.nvvi9.giffi.network.model.TrendingResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class GiphyApiServiceImpl @Inject constructor(
    private val httpClient: HttpClient
) : GiphyApiService {

    override suspend fun getTrending(): TrendingResponse =
        httpClient.get("gifs/trending").body()
}