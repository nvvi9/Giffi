package com.nvvi9.giffi.database.model

import androidx.room.Embedded
import androidx.room.Relation

data class GifAndAuthor(
    @Embedded val gifAuthorEntity: GifAuthorEntity,
    @Relation(parentColumn = "username", entityColumn = "authorUsername")
    val gifDataEntity: GifDataEntity
)