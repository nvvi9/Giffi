package com.nvvi9.giffi.navigation

import com.nvvi9.giffi.R
import com.nvvi9.giffi.ui.icon.Icon
import com.nvvi9.giffi.ui.icon.GiffiIcons

enum class TopLevelDestination(
    val selectedIcon: Icon,
    val unselectedIcon: Icon,
    val iconTextId: Int,
    val titleTextId: Int
) {
    TRENDING(
        selectedIcon = Icon.DrawableResourceIcon(GiffiIcons.Trending),
        unselectedIcon = Icon.DrawableResourceIcon(GiffiIcons.TrendingBorder),
        iconTextId = R.string.trending,
        titleTextId = R.string.app_name
    ),
    FAVORITES(
        selectedIcon = Icon.ImageVectorIcon(GiffiIcons.Favorite),
        unselectedIcon = Icon.ImageVectorIcon(GiffiIcons.FavoriteBorder),
        iconTextId = R.string.favorites,
        titleTextId = R.string.app_name
    )
}