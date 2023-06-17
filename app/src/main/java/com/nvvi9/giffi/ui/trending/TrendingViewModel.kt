package com.nvvi9.giffi.ui.trending

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nvvi9.giffi.repositories.GifsRepository
import com.nvvi9.giffi.ui.core.GifsListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val gifsRepository: GifsRepository
) : ViewModel() {

    private val _gifListUiState = MutableStateFlow<GifsListUiState>(GifsListUiState.Loading)
    val gifListUiState: StateFlow<GifsListUiState> get() = _gifListUiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            _gifListUiState.emitAll(gifsRepository.getUserGifs())
        }
    }
}