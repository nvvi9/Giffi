package com.nvvi9.giffi.database.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.datetime.Instant

@Entity(
    tableName = "gifs",
    foreignKeys = [
        ForeignKey(
            entity = GifAuthorEntity::class,
            parentColumns = ["username"],
            childColumns = ["authorUsername"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index(value = ["authorUsername"])]
)
data class GifDataEntity(
    @PrimaryKey val id: String,
    val title: String,
    val gifUrl: String,
    val publishDate: Instant,
    val size: Int,
    val authorUsername: String
)