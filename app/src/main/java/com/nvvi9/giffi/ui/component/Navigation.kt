package com.nvvi9.giffi.ui.component

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.NavigationRailItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun GiffiNavigationBar(
    modifier: Modifier = Modifier,
    content: @Composable RowScope.() -> Unit
) {
    NavigationBar(
        modifier = modifier,
        contentColor = GiffiNavigationDefaults.navigationContentColor,
        tonalElevation = 0.dp,
        content = content
    )
}

@Composable
fun RowScope.GiffiNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationBarItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationBarItemDefaults.colors(
            selectedIconColor = GiffiNavigationDefaults.navigationSelectedItemColor,
            unselectedIconColor = GiffiNavigationDefaults.navigationContentColor,
            selectedTextColor = GiffiNavigationDefaults.navigationSelectedItemColor,
            unselectedTextColor = GiffiNavigationDefaults.navigationContentColor,
            indicatorColor = GiffiNavigationDefaults.navigationIndicatorColor
        )
    )
}

@Composable
fun GiffiNavigationRailItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    selectedIcon: @Composable () -> Unit = icon,
    enabled: Boolean = true,
    label: @Composable (() -> Unit)? = null,
    alwaysShowLabel: Boolean = true
) {
    NavigationRailItem(
        selected = selected,
        onClick = onClick,
        icon = if (selected) selectedIcon else icon,
        modifier = modifier,
        enabled = enabled,
        label = label,
        alwaysShowLabel = alwaysShowLabel,
        colors = NavigationRailItemDefaults.colors(
            selectedIconColor = GiffiNavigationDefaults.navigationSelectedItemColor,
            unselectedIconColor = GiffiNavigationDefaults.navigationContentColor,
            selectedTextColor = GiffiNavigationDefaults.navigationSelectedItemColor,
            unselectedTextColor = GiffiNavigationDefaults.navigationContentColor,
            indicatorColor = GiffiNavigationDefaults.navigationIndicatorColor
        )
    )
}

@Composable
fun GiffiNavigationRail(
    modifier: Modifier = Modifier,
    header: @Composable (ColumnScope.() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {
    NavigationRail(
        modifier = modifier,
        containerColor = Color.Transparent,
        contentColor = GiffiNavigationDefaults.navigationContentColor,
        header = header,
        content = content
    )
}

object GiffiNavigationDefaults {
    val navigationContentColor @Composable get() = MaterialTheme.colorScheme.onSurfaceVariant
    val navigationSelectedItemColor @Composable get() = MaterialTheme.colorScheme.onPrimaryContainer
    val navigationIndicatorColor @Composable get() = MaterialTheme.colorScheme.primaryContainer
}