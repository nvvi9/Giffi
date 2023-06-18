package com.nvvi9.giffi.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "gif_authors")
data class GifAuthorEntity(
    @PrimaryKey val username: String,
    val displayName: String,
    val avatarUrl: String,
    val description: String,
    val bannerImage: String,
    val isVerified: Boolean
)