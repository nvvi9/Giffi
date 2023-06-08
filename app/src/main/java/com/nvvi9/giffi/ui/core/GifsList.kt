package com.nvvi9.giffi.ui.core

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.nvvi9.giffi.ui.theme.GiffiTheme
import com.nvvi9.giffi.vo.UserGifResource

fun LazyGridScope.gifsList(
    listState: GifsListUiState,
    onItemClicked: () -> Unit
) {
    when (listState) {
        GifsListUiState.Loading -> Unit
        is GifsListUiState.Success -> {
            items(listState.gifs, key = { it.id }) { userGifResource ->
                GifResourceCardExpanded(
                    userGifResource = userGifResource,
                    onClick = onItemClicked,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

sealed interface GifsListUiState {
    object Loading : GifsListUiState
    data class Success(val gifs: List<UserGifResource>) : GifsListUiState
}

@Preview
@Composable
private fun GifListContentPreview(
    @PreviewParameter(UserGifResourcePreviewParameterProvider::class) userGifResources: List<UserGifResource>
) {
    GiffiTheme {
        LazyVerticalGrid(columns = GridCells.Adaptive(300.dp)) {
            gifsList(listState = GifsListUiState.Success(userGifResources), onItemClicked = {})
        }
    }
}