package com.nvvi9.giffi.ui

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.nvvi9.giffi.navigation.TopLevelDestination
import com.nvvi9.giffi.ui.favorites.navigation.favoritesRoute
import com.nvvi9.giffi.ui.favorites.navigation.navigateToFavorites
import com.nvvi9.giffi.ui.trending.navigation.navigateToTrending
import com.nvvi9.giffi.ui.trending.navigation.trendingNavigationRoute

@Composable
fun rememberGiffiAppState(
    windowSizeClass: WindowSizeClass,
    navController: NavHostController = rememberNavController()
): GiffiAppState = remember(navController, windowSizeClass) {
    GiffiAppState(navController, windowSizeClass)
}

@Stable
class GiffiAppState(val navController: NavHostController, val windowSizeClass: WindowSizeClass) {

    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            trendingNavigationRoute -> TopLevelDestination.TRENDING
            favoritesRoute -> TopLevelDestination.FAVORITES
            else -> null
        }

    val shouldShowBottomBar: Boolean
        get() = windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact

    val shouldShowNavRail: Boolean
        get() = !shouldShowBottomBar

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.values().asList()

    fun navigateToTopLevelDestination(topLevelDestination: TopLevelDestination) {
        val topLevelNavOptions = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
        when (topLevelDestination) {
            TopLevelDestination.TRENDING -> navController.navigateToTrending(topLevelNavOptions)
            TopLevelDestination.FAVORITES -> navController.navigateToFavorites(topLevelNavOptions)
        }
    }
}