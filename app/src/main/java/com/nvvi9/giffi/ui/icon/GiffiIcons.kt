package com.nvvi9.giffi.ui.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.ui.graphics.vector.ImageVector
import com.nvvi9.giffi.R

object GiffiIcons {
    val Trending = R.drawable.ic_star
    val TrendingBorder = R.drawable.ic_star_border
    val Favorite = Icons.Rounded.Favorite
    val FavoriteBorder = Icons.Rounded.FavoriteBorder
}

sealed interface Icon {
    @JvmInline
    value class ImageVectorIcon(val imageVector: ImageVector) : Icon

    @JvmInline
    value class DrawableResourceIcon(@DrawableRes val id: Int) : Icon
}