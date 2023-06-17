package com.nvvi9.giffi

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import javax.inject.Inject

@HiltAndroidApp
class GiffiApplication : Application(), ImageLoaderFactory {

    override fun onCreate() {
        super.onCreate()
        Napier.base(DebugAntilog())
    }

    @Inject
    lateinit var imageLoader: ImageLoader

    override fun newImageLoader(): ImageLoader = imageLoader
}