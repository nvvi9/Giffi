package com.nvvi9.giffi.network.model

import com.nvvi9.giffi.network.model.util.InstantSerializer
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TrendingResponse(
    val `data`: List<Data>,
    val pagination: Pagination,
    val meta: Meta
) {
    @Serializable
    data class Data(
        val type: String,
        val id: String,
        val url: String,
        val slug: String,
        @SerialName("bitly_gif_url")
        val bitlyGifUrl: String,
        @SerialName("bitly_url")
        val bitlyUrl: String,
        @SerialName("embed_url")
        val embedUrl: String,
        val username: String,
        val source: String,
        val title: String,
        val rating: String,
        @SerialName("content_url")
        val contentUrl: String,
        @SerialName("source_tld")
        val sourceTld: String,
        @SerialName("source_post_url")
        val sourcePostUrl: String,
        @SerialName("is_sticker")
        val isSticker: Int,
        @SerialName("import_datetime")
        @Serializable(InstantSerializer::class)
        val importDatetime: Instant,
        @SerialName("trending_datetime")
        val trendingDatetime: String,
        val images: Images,
        val user: User?,
        @SerialName("analytics_response_payload")
        val analyticsResponsePayload: String,
        val analytics: Analytics
    ) {
        @Serializable
        data class Images(
            val original: Original,
            val downsized: Downsized,
            @SerialName("downsized_large")
            val downsizedLarge: DownsizedLarge,
            @SerialName("downsized_medium")
            val downsizedMedium: DownsizedMedium,
            @SerialName("downsized_small")
            val downsizedSmall: DownsizedSmall,
            @SerialName("downsized_still")
            val downsizedStill: DownsizedStill,
            @SerialName("fixed_height")
            val fixedHeight: FixedHeight,
            @SerialName("fixed_height_downsampled")
            val fixedHeightDownsampled: FixedHeightDownsampled,
            @SerialName("fixed_height_small")
            val fixedHeightSmall: FixedHeightSmall,
            @SerialName("fixed_height_small_still")
            val fixedHeightSmallStill: FixedHeightSmallStill,
            @SerialName("fixed_height_still")
            val fixedHeightStill: FixedHeightStill,
            @SerialName("fixed_width")
            val fixedWidth: FixedWidth,
            @SerialName("fixed_width_downsampled")
            val fixedWidthDownsampled: FixedWidthDownsampled,
            @SerialName("fixed_width_small")
            val fixedWidthSmall: FixedWidthSmall,
            @SerialName("fixed_width_small_still")
            val fixedWidthSmallStill: FixedWidthSmallStill,
            @SerialName("fixed_width_still")
            val fixedWidthStill: FixedWidthStill,
            val looping: Looping,
            @SerialName("original_still")
            val originalStill: OriginalStill,
            @SerialName("original_mp4")
            val originalMp4: OriginalMp4,
            val preview: Preview,
            @SerialName("preview_gif")
            val previewGif: PreviewGif,
            @SerialName("preview_webp")
            val previewWebp: PreviewWebp,
            val hd: Hd?,
            @SerialName("480w_still")
            val wStill: WStill
        ) {
            @Serializable
            data class Original(
                val height: String,
                val width: String,
                val size: String,
                val url: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String,
                @SerialName("webp_size")
                val webpSize: String,
                val webp: String,
                val frames: String,
                val hash: String
            )

            @Serializable
            data class Downsized(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class DownsizedLarge(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class DownsizedMedium(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class DownsizedSmall(
                val height: String,
                val width: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String
            )

            @Serializable
            data class DownsizedStill(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class FixedHeight(
                val height: String,
                val width: String,
                val size: String,
                val url: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String,
                @SerialName("webp_size")
                val webpSize: String,
                val webp: String
            )

            @Serializable
            data class FixedHeightDownsampled(
                val height: String,
                val width: String,
                val size: String,
                val url: String,
                @SerialName("webp_size")
                val webpSize: String,
                val webp: String
            )

            @Serializable
            data class FixedHeightSmall(
                val height: String,
                val width: String,
                val size: String,
                val url: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String,
                @SerialName("webp_size")
                val webpSize: String,
                val webp: String
            )

            @Serializable
            data class FixedHeightSmallStill(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class FixedHeightStill(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class FixedWidth(
                val height: String,
                val width: String,
                val size: String,
                val url: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String,
                @SerialName("webp_size")
                val webpSize: String,
                val webp: String
            )

            @Serializable
            data class FixedWidthDownsampled(
                val height: String,
                val width: String,
                val size: String,
                val url: String,
                @SerialName("webp_size")
                val webpSize: String,
                val webp: String
            )

            @Serializable
            data class FixedWidthSmall(
                val height: String,
                val width: String,
                val size: String,
                val url: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String,
                @SerialName("webp_size")
                val webpSize: String,
                val webp: String
            )

            @Serializable
            data class FixedWidthSmallStill(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class FixedWidthStill(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class Looping(
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String
            )

            @Serializable
            data class OriginalStill(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class OriginalMp4(
                val height: String,
                val width: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String
            )

            @Serializable
            data class Preview(
                val height: String,
                val width: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String
            )

            @Serializable
            data class PreviewGif(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class PreviewWebp(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )

            @Serializable
            data class Hd(
                val height: String,
                val width: String,
                @SerialName("mp4_size")
                val mp4Size: String,
                val mp4: String
            )

            @Serializable
            data class WStill(
                val height: String,
                val width: String,
                val size: String,
                val url: String
            )
        }

        @Serializable
        data class User(
            @SerialName("avatar_url")
            val avatarUrl: String,
            @SerialName("banner_image")
            val bannerImage: String,
            @SerialName("banner_url")
            val bannerUrl: String,
            @SerialName("profile_url")
            val profileUrl: String,
            val username: String,
            @SerialName("display_name")
            val displayName: String,
            val description: String,
            @SerialName("instagram_url")
            val instagramUrl: String,
            @SerialName("website_url")
            val websiteUrl: String,
            @SerialName("is_verified")
            val isVerified: Boolean
        )

        @Serializable
        data class Analytics(
            val onload: Onload,
            val onclick: Onclick,
            val onsent: Onsent
        ) {
            @Serializable
            data class Onload(
                val url: String
            )

            @Serializable
            data class Onclick(
                val url: String
            )

            @Serializable
            data class Onsent(
                val url: String
            )
        }
    }

    @Serializable
    data class Pagination(
        @SerialName("total_count")
        val totalCount: Int,
        val count: Int,
        val offset: Int
    )

    @Serializable
    data class Meta(
        val status: Int,
        val msg: String,
        @SerialName("response_id")
        val responseId: String
    )
}