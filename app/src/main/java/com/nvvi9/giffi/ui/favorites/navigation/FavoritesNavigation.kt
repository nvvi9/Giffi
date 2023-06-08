package com.nvvi9.giffi.ui.favorites.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nvvi9.giffi.ui.favorites.FavoritesRoute

const val favoritesRoute = "favorites_route"

fun NavController.navigateToFavorites(navOptions: NavOptions? = null) {
    this.navigate(favoritesRoute, navOptions)
}

fun NavGraphBuilder.favoritesScreen() {
    composable(route = favoritesRoute) {
        FavoritesRoute()
    }
}