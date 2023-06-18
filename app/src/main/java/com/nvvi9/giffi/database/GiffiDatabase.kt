package com.nvvi9.giffi.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nvvi9.giffi.database.dao.GifAuthorDao
import com.nvvi9.giffi.database.dao.GifDataDao
import com.nvvi9.giffi.database.model.GifAuthorEntity
import com.nvvi9.giffi.database.model.GifDataEntity
import com.nvvi9.giffi.database.util.InstantConverter

@Database(
    entities = [GifDataEntity::class, GifAuthorEntity::class],
    version = 1,
    exportSchema = true
)
@TypeConverters(InstantConverter::class)
abstract class GiffiDatabase : RoomDatabase() {
    abstract val gifAuthorDao: GifAuthorDao
    abstract val gifDataDao: GifDataDao
}
