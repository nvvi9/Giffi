package com.nvvi9.giffi.repositories

import com.nvvi9.giffi.network.GiphyDataSource
import com.nvvi9.giffi.network.model.TrendingResponse
import com.nvvi9.giffi.ui.core.GifsListUiState
import com.nvvi9.giffi.vo.toUserGifResourceList
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class GifsRepositoryImpl @Inject constructor(
    private val giphyDataSource: GiphyDataSource
) : GifsRepository {

    override fun getUserGifs(): Flow<GifsListUiState> = flow {
        emit(giphyDataSource.getTrending())
    }.map<Result<TrendingResponse>, GifsListUiState> { result ->
        result.fold(
            { GifsListUiState.Success(it.toUserGifResourceList()) },
            { GifsListUiState.Success(emptyList()) }
        )
    }
        .onStart { emit(GifsListUiState.Loading) }
}