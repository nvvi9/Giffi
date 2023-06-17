package com.nvvi9.giffi.vo

import com.nvvi9.giffi.network.model.TrendingResponse
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

data class UserGifResource(
    val id: String,
    val title: String,
    val gifUrl: String,
    val publishDate: Instant
) {
    companion object {
        val sample
            get() = (1..100000).map {
                UserGifResource(
                    id = it.toString(),
                    title = "title$it",
                    gifUrl = "https://media0.giphy.com/media/rrmf3fICPZWg1MMXOW/giphy-downsized.gif?cid=d1541ff4np6t0i8nau903dw1qre4ss7r38ylh7ofmzlfmb6x&ep=v1_gifs_trending&rid=giphy-downsized.gif&ct=g",
                    publishDate = Clock.System.now()
                )
            }
    }
}

fun TrendingResponse.toUserGifResourceList() = data.map { data ->
    UserGifResource(
        id = data.id,
        title = data.title,
        gifUrl = data.images.downsized.url,
        publishDate = data.importDatetime
    )
}