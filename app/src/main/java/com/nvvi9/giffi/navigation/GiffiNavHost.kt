package com.nvvi9.giffi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.nvvi9.giffi.ui.GiffiAppState
import com.nvvi9.giffi.ui.favorites.navigation.favoritesScreen
import com.nvvi9.giffi.ui.trending.navigation.trendingNavigationRoute
import com.nvvi9.giffi.ui.trending.navigation.trendingScreen

@Composable
fun GiffiNavHost(
    appState: GiffiAppState,
    modifier: Modifier = Modifier,
    startDestination: String = trendingNavigationRoute
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        trendingScreen {  }
        favoritesScreen()
    }
}
