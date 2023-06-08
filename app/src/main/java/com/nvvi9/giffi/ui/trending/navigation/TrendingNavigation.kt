package com.nvvi9.giffi.ui.trending.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.nvvi9.giffi.ui.trending.TrendingRoute

const val trendingNavigationRoute = "trending_route"

fun NavController.navigateToTrending(navOptions: NavOptions? = null) {
    this.navigate(trendingNavigationRoute, navOptions)
}

fun NavGraphBuilder.trendingScreen(onItemClicked: () -> Unit) {
    composable(route = trendingNavigationRoute) {
        TrendingRoute(onItemClicked)
    }
}