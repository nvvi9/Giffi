package com.nvvi9.giffi.ui.core

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import com.nvvi9.giffi.vo.UserGifResource

class UserGifResourcePreviewParameterProvider : PreviewParameterProvider<List<UserGifResource>> {
    override val values: Sequence<List<UserGifResource>>
        get() = sequenceOf(UserGifResource.sample)
}