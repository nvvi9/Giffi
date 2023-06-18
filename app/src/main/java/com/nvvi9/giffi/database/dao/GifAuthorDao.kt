package com.nvvi9.giffi.database.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.nvvi9.giffi.database.model.GifAuthorEntity

@Dao
interface GifAuthorDao {

    @Upsert
    suspend fun upsertGifAuthors(gifAuthorEntities: List<GifAuthorEntity>)
}