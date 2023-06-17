package com.nvvi9.giffi.repositories

import com.nvvi9.giffi.ui.core.GifsListUiState
import kotlinx.coroutines.flow.Flow

interface GifsRepository {
    fun getUserGifs(): Flow<GifsListUiState>
}