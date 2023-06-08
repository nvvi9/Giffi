package com.nvvi9.giffi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.DisposableEffect
import androidx.core.view.WindowCompat
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.nvvi9.giffi.ui.GiffiApp
import com.nvvi9.giffi.ui.theme.GiffiTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            val systemUiController = rememberSystemUiController()
            DisposableEffect(systemUiController, false) {
                systemUiController.systemBarsDarkContentEnabled = true
                onDispose { }
            }
            GiffiTheme {
                GiffiApp(windowSizeClass = calculateWindowSizeClass(activity = this))
            }
        }
    }
}