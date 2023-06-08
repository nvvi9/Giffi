package com.nvvi9.giffi.ui.trending

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nvvi9.giffi.ui.core.GifsListUiState
import com.nvvi9.giffi.ui.core.gifsList
import com.nvvi9.giffi.vo.UserGifResource

@Composable
fun TrendingRoute(onItemClicked: () -> Unit, modifier: Modifier = Modifier) {
    TrendingScreen(
        gifsListUiState = GifsListUiState.Success(UserGifResource.sample),
        onItemClicked = onItemClicked,
        modifier = modifier
    )
}

@Composable
fun TrendingScreen(
    gifsListUiState: GifsListUiState,
    onItemClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val state = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Adaptive(300.dp),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
            .fillMaxSize(),
        state = state
    ) {
        gifsList(
            listState = gifsListUiState,
            onItemClicked = onItemClicked
        )
    }
}