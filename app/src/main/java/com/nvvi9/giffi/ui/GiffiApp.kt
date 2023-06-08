package com.nvvi9.giffi.ui

import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.nvvi9.giffi.navigation.GiffiNavHost
import com.nvvi9.giffi.navigation.TopLevelDestination
import com.nvvi9.giffi.ui.component.GiffiBackground
import com.nvvi9.giffi.ui.component.GiffiGradientBackground
import com.nvvi9.giffi.ui.component.GiffiNavigationBar
import com.nvvi9.giffi.ui.component.GiffiNavigationBarItem
import com.nvvi9.giffi.ui.component.GiffiNavigationRail
import com.nvvi9.giffi.ui.component.GiffiNavigationRailItem
import com.nvvi9.giffi.ui.icon.Icon
import com.nvvi9.giffi.ui.theme.LocalGradientColors

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun GiffiApp(
    windowSizeClass: WindowSizeClass,
    appState: GiffiAppState = rememberGiffiAppState(windowSizeClass = windowSizeClass)
) {
    GiffiBackground {
        GiffiGradientBackground(gradientColors = LocalGradientColors.current) {
            Scaffold(
                containerColor = Color.Transparent,
                contentColor = MaterialTheme.colorScheme.onBackground,
                contentWindowInsets = WindowInsets(0, 0, 0, 0),
                bottomBar = {
                    if (appState.shouldShowBottomBar) {
                        GiffiBottomBar(
                            destinations = appState.topLevelDestinations,
                            onNavigateToDestination = appState::navigateToTopLevelDestination,
                            currentDestination = appState.currentDestination
                        )
                    }
                }
            ) { padding ->
                Row(
                    Modifier
                        .fillMaxSize()
                        .padding(padding)
                        .consumeWindowInsets(padding)
                        .windowInsetsPadding(WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal))
                ) {
                    if (appState.shouldShowNavRail) {
                        GiffiNavRail(
                            destinations = appState.topLevelDestinations,
                            onNavigateToDestination = appState::navigateToTopLevelDestination,
                            currentDestination = appState.currentDestination,
                            modifier = Modifier.safeDrawingPadding()
                        )
                    }

                    GiffiNavHost(appState = appState)
                }
            }
        }
    }
}

@Composable
private fun GiffiBottomBar(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    GiffiNavigationBar(modifier = modifier) {
        for (destination in destinations) {
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            GiffiNavigationBarItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon =
                        if (selected) destination.selectedIcon else destination.unselectedIcon
                    when (icon) {
                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )

                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )
                    }
                },
                label = { Text(stringResource(destination.iconTextId)) }
            )
        }
    }
}

@Composable
private fun GiffiNavRail(
    destinations: List<TopLevelDestination>,
    onNavigateToDestination: (TopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
    modifier: Modifier = Modifier
) {
    GiffiNavigationRail(modifier = modifier) {
        for (destination in destinations) {
            val selected = currentDestination.isTopLevelDestinationInHierarchy(destination)
            GiffiNavigationRailItem(
                selected = selected,
                onClick = { onNavigateToDestination(destination) },
                icon = {
                    val icon =
                        if (selected) destination.selectedIcon else destination.unselectedIcon
                    when (icon) {
                        is Icon.DrawableResourceIcon -> Icon(
                            painter = painterResource(id = icon.id),
                            contentDescription = null
                        )

                        is Icon.ImageVectorIcon -> Icon(
                            imageVector = icon.imageVector,
                            contentDescription = null
                        )
                    }
                },
                label = { Text(text = stringResource(id = destination.iconTextId)) })
        }
    }
}

private fun NavDestination?.isTopLevelDestinationInHierarchy(destination: TopLevelDestination) =
    this?.hierarchy?.any { it.route?.contains(destination.name, true) ?: false } ?: false
