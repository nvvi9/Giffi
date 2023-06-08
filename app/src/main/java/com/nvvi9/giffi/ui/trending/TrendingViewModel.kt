package com.nvvi9.giffi.ui.trending

import androidx.lifecycle.ViewModel
import com.nvvi9.giffi.ui.core.GifsListUiState
import com.nvvi9.giffi.vo.UserGifResource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor() : ViewModel() {

    private val _gifListUiState = MutableStateFlow<GifsListUiState>(GifsListUiState.Loading)
    val gifListUiState: StateFlow<GifsListUiState> get() = _gifListUiState

    init {
        _gifListUiState.value = GifsListUiState.Success(UserGifResource.sample)
    }
}