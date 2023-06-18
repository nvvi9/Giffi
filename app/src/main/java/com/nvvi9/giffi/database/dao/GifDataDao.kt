package com.nvvi9.giffi.database.dao

import androidx.room.Dao
import androidx.room.Upsert
import com.nvvi9.giffi.database.model.GifDataEntity

@Dao
interface GifDataDao {

    @Upsert
    suspend fun upsertGifData(gifDataEntities: List<GifDataEntity>)
}